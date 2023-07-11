package com.betrybe.sistemadevotacao;

import static com.betrybe.sistemadevotacao.util.ClassChecker.checkClassFields;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTest {
  @Test
  @DisplayName("1 - Implemente a classe abstrata Pessoa")
  public void testPessoaClass()
      throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    Class<?> classToCheck = Pessoa.class;

    // Check if attributes are correct
    Map<String, String> expectedFields = Map.of(
        "nome", String.class.getName()
    );
    checkClassFields(classToCheck, expectedFields);

    // Check if class is abstract
    assertTrue(
        Modifier.isAbstract(classToCheck.getModifiers()),
        "Classe Pessoa deve ser abstrata"
    );

    // Define concrete class just to test the methods of the abstract one
    try {
      classToCheck.getMethod("getNome");
      classToCheck.getMethod("setNome", String.class);
    } catch (Exception e){
      fail("Classe Pessoa deve conter setters e getters do atributo 'nome'");
    }
  }
}
