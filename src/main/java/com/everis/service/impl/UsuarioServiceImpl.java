/*package com.everis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import com.everis.repository.UsuarioRepoJPA;
import com.everis.service.UsuarioService;
import com.everis.repository.entity.Usuario;
import com.everis.DemoWebApplication;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{
	
	private static Logger LOG = org.slf4j.LoggerFactory.getLogger(DemoWebApplication.class);
	
	@Autowired
	UsuarioRepoJPA usuarioDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public List<Usuario> listar() {
		return usuarioDAO.findAll(); 
	}
	
	@Override
	public Usuario buscarPorUsername(String username) {
		Usuario u = usuarioDAO.findById(username).get();
		LOG.info("UsuarioServiceImpl - "+ u.getUsername() + ": " + passwordEncoder().encode(u.getPassword()));
		return usuarioDAO.findById(username).get();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return buscarPorUsername(username);
	}
	
}*/