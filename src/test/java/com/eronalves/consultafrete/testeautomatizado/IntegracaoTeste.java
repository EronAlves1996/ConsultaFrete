package com.eronalves.consultafrete.testeautomatizado;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/formato_cep_aceito.feature" })
public class IntegracaoTeste {

}
