package com.TranslationApi.Translation.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.TranslationApi.Translation.Services.TranslatorService;


@RestController
@RequestMapping(value = "/translatorcontroller1")
public class Translatorcontroller {

	@Autowired
	private TranslatorService translatorservice;

	@RequestMapping(value = "/translatetext", method = RequestMethod.POST)
	public Map translateText(@RequestBody Map jsonMap) throws Exception {
		String fromLang = "en";
		String toLang = "fr";
		String text = jsonMap.get("text").toString();
		Map res = new HashMap();
		try {
			res = translatorservice.translate(fromLang, toLang, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;

	}
}
