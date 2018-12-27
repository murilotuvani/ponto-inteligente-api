package br.com.autogeral.pontointeligente.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.autogeral.pontointeligente.api.entities.Empresa;
import br.com.autogeral.pontointeligente.api.repositories.EmpresaRepository;
import br.com.autogeral.pontointeligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Empresa persistir(Empresa empresa) {
		empresa = empresaRepository.save(empresa);
		logger.info("Salvou a empresa {}", empresa);
		return empresa;
	}

	@Override
	public Optional<Empresa> buscaPorCnpj(String cnpj) {
		logger.info("Buscando empresa para o CNPJ {}", cnpj);
		Optional<Empresa> optional = Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
		return optional;
	}

	@Override
	public List<Empresa> list() {
		logger.info("Listagem de empresas");
		List<Empresa> list = empresaRepository.findAll();
		return list;
	}

}
