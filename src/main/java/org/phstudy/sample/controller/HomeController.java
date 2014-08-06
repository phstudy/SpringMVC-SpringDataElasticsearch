package org.phstudy.sample.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import net._01001111.text.LoremIpsum;

import org.phstudy.sample.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;

	private static final int MINCOUNT = 100;
	private static final int MAXCOUNT = 200;

	@PostConstruct
	private void initData() {
		List<IndexQuery> indexQueries = new ArrayList<IndexQuery>();
		LoremIpsum lorem = new LoremIpsum();
		for (int i = MINCOUNT; i < MAXCOUNT; i++) {
			String documentId = UUID.randomUUID().toString();
			Book book = new Book();
			book.setId(documentId);
			book.setMessage(lorem.paragraph());
			IndexQuery indexQuery = new IndexQueryBuilder()
					.withId(book.getId()).withObject(book).build();
			indexQueries.add(indexQuery);
		}

		// bulk index
		elasticsearchTemplate.bulkIndex(indexQueries);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
	@RequestMapping(value = "/httpservletrequest", method = RequestMethod.GET)
	public String httpservletrequest(Locale locale, Model model) {
		model.addAttribute("url", "./rest/book2");
		return "book";
	}

	@RequestMapping(value = "/pageable", method = RequestMethod.GET)
	public String pageable(Locale locale, Model model) {
		model.addAttribute("url", "./rest/book1");
		return "book";
	}
	
	@RequestMapping(value = "/requestparam", method = RequestMethod.GET)
	public String requestparam(Locale locale, Model model) {
		model.addAttribute("url", "./rest/book3");
		return "book";
	}
}
