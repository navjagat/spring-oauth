package com.practice.acl.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.practice.acl.entiry.Client;
import com.practice.acl.repo.ClientRepository;

public class CustomArgumentResolver extends
		HandlerMethodArgumentResolverComposite {
	
	@Autowired
	private ClientRepository repository;

	public void setRepository(ClientRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		boolean isValid = parameter.getParameterAnnotation(ActiveClient.class) != null;

		isValid &= parameter.getParameterType().equals(Client.class);

		return isValid;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		
		if(authentication == null)
			return null;
		Client client = repository.findOne((String) authentication.getPrincipal());
		
		return client;
	}
}
