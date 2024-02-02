package com.barbershop.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.barbershop.domain.address.dto.CreateAddressDTO;
import com.barbershop.domain.user.dto.CreateUserDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<CreateUserDTO> createUserJson;

    @Test
    void testUserControllers() throws Exception {
        CreateAddressDTO createAddress = new CreateAddressDTO("31800112", "Rua dos Bobos", "3", "Cidade Aleatória",
                "Minas Gerais", "Brasil");
        CreateUserDTO createUserDTO = new CreateUserDTO(createAddress, "Pedro", "Cecilio", "pedro@gmail.com", "123456",
                false);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
                .post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserJson.write(
                        createUserDTO).getJson()))
                .andReturn().getResponse();
                
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }
}
