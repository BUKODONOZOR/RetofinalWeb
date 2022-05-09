package com.crud.democrud.ControllerServiceTest;

import com.crud.democrud.repositories.TareaRepository;
import com.crud.democrud.services.TareaService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;


import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class TareaServiceMockTest {

  @MockBean
  TareaRepository usuarioRepository;

  @Autowired
  TareaService usuarioService;

  @Test
  public void testUsuarioMock(){
    when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());
    assertThat(usuarioService.obtenerTareas()).isEmpty();
    verify(usuarioRepository).findAll();
  }

}
