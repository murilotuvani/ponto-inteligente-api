package br.com.autogeral.pontointeligente.api.services;

import java.util.Optional;

import br.com.autogeral.pontointeligente.api.entities.Empresa;

public interface EmpresaService {
	
	/**
	 * Cadastra uma nova empresa na base de dados.
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa persistir(Empresa empresa);
	
	/**
	 * Retorna uma empresa dado um CNPJ.
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscaPorCnpj(String cnpj);

}
