package com.TranslationApi.Translation.Services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface TranslatorService {
	public Map translate(String fromLang, String toLang, String text) throws Exception;
}
