package br.com.maverick.api.common.service;

import br.com.maverick.api.common.model.CepAddress;
import br.com.maverick.api.common.repository.ViaCepWS;
import org.springframework.stereotype.Service;

@Service
public class CepService {

    public CepAddress searchCep(String cep){
        CepAddress cepAddress = new CepAddress();

        ViaCepWS viaCepWS = ViaCepWS.searchCep(cep);

        if(viaCepWS.wasSuccessful()) {

            cepAddress.setCityName(viaCepWS.getCidade());
            cepAddress.setNeighborhoodName(viaCepWS.getBairro());
            cepAddress.setCep(viaCepWS.getCep());
            cepAddress.setStateNick(viaCepWS.getUf());
            cepAddress.setStreetName(viaCepWS.getLogradouroFull());

        } else {
            throw new RuntimeException("Erro: "+viaCepWS.getResulCode()+" - "+viaCepWS.getResultText());
        }
        return cepAddress;
    }



}
