package com.eronalves.consultafrete.service;

import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.exception.CepInexistenteException;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;

/**
 * Interface do Serviço que irá executar a regra de negócio da aplicação
 * 
 * @author eronads
 *
 */
public interface ConsultaService {
	/**
	 * Executa a regra principal de negócio que consulta o endereço e o frete de uma
	 * localidade
	 * 
	 * @param dto
	 * @return
	 * @throws ConsultaException
	 * @throws ApiTimeoutException
	 * @throws CepInexistenteException
	 */
	ConsultaDto consultaFrete(ConsultaDto dto) throws ConsultaException, ApiTimeoutException, CepInexistenteException;

}
