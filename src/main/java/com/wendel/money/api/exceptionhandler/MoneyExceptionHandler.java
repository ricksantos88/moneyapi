package com.wendel.money.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MoneyExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String mensagemUsuario = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvoldor = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		
		List<Erro> erros= Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvoldor));
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	};
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	};
	
	@ExceptionHandler( { EmptyResultDataAccessException.class } )
	public ResponseEntity<Object> handleEmptyResultDataAccessException (RuntimeException ex, WebRequest request) {
		String mensagemUsuario = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
		String mensagemDesenvoldor = ex.toString();
		List<Erro> erros= Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvoldor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	};
	
	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request){
		String mensagemUsuario = messageSource.getMessage("recurso.operacao-nao-permitida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvoldor = ExceptionUtils.getRootCauseMessage(ex);
		List<Erro> erros= Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvoldor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criarListaDeErros(BindingResult bindigResult){
		List<Erro> erros = new ArrayList<>();
		for (FieldError fieldError : bindigResult.getFieldErrors()) {
			String mensagemUsario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String mensagemDesenvolvedor = fieldError.toString();
			
			erros.add(new Erro(mensagemUsario, mensagemDesenvolvedor));
		};
		return erros;
	};
	
	public static class Erro{
		
		private String mensagemUsario;
		private String mensagemDesenvolvedor;
		public Erro(String mensagemUsario, String mensagemDesenvolvedor) {
			super();
			this.mensagemUsario = mensagemUsario;
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}
		public String getMensagemUsario() {
			return mensagemUsario;
		}
		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}
		
	}

}
