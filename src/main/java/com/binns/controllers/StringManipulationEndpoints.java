package com.binns.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.binns.business.StringManipulator;
import com.binns.data.StringData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "string operations")
@RestController
@RequestMapping(value = "/string")
public class StringManipulationEndpoints {
	
	@ApiOperation(value = "Get Untouched String", nickname = "String forward")
	@RequestMapping(value = "/forward/{input}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public StringData forward(@ApiParam(value = "The input string", required = true) @PathVariable final String input) {
		return StringManipulator.forward(input);
	}
	
	@ApiOperation(value = "Get Reversed String", nickname = "String reverse")
	@RequestMapping(value = "/reverse/{input}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public StringData reverse(@PathVariable final String input) {
		return StringManipulator.reverse(input);
	}
	
	@ApiOperation(value = "Get String With Vowels Removed", nickname = "String with removed vowels")
	@RequestMapping(value = "/dropVowels/{input}", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public StringData dropVowels(@PathVariable final String input) {
		return StringManipulator.dropVowels(input);
	}

}
