/*
package com.boutiqueEnLigne.fngcine;

import com.boutiqueEnLigne.fngcine.controller.AuthController;
import com.boutiqueEnLigne.fngcine.entity.EnumRole;
import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.entity.Role;
import com.boutiqueEnLigne.fngcine.entity.User;
import com.boutiqueEnLigne.fngcine.repository.RoleRepository;
import com.boutiqueEnLigne.fngcine.repository.UserRepository;
import com.boutiqueEnLigne.fngcine.security.jwt.JwtUtils;
import com.boutiqueEnLigne.fngcine.service.ProductService;
import com.boutiqueEnLigne.fngcine.service.UserService;
import com.boutiqueEnLigne.fngcine.validation.AuthentificationValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.*;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Resource
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    User testUser = new User();
    Long userId;

    public void setTestUser() {
        Set<Role> roles = new HashSet<Role>();
        Optional<Role> optionalRole = roleRepository.findByName(EnumRole.USER);
        Role userRole = optionalRole.get();
        roles.add(userRole);
        String password = encoder.encode("Totouser22@");
        testUser.setId(6L);
        testUser.setLastName("Toto");
        testUser.setFirstName("Toto");
        testUser.setEmail("toto@mail.com");
        testUser.setUsername("userTOTO");
        testUser.setPassword(password);
        testUser.setRoles(roles);
        testUser.setOrdersList(null);

        userRepository.save(testUser);
        userId = testUser.getId();
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setup() {
        */
/*mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();*//*

    }

*/
/*    @Test
    @WithMockUser(username = "user", password = "pwd")
    public void simpleTest() throws Exception {
        @Test
        public void authTest() throws Exception {
            mockMvc.perform(
                    get("/data")
                            //Créer l'utilisateur authentifié pour la requête, possible de l'attribuer
                            //des rôles aussi.
                            .with(user("user").password("pwd").roles("ROLE1","ROLE2"))
            );
        }
    }*//*


    @Test
    public void authTest() throws Exception {
        mockMvc.perform(
                //Créer une requête Rest de type PUT.
                put("/data")
                        //Attribuer le type de contenue de la requête.
                        .contentType(MediaType.APPLICATION_JSON)
                        //Attribuer le contenue de la requête sous forme json.
                        .content("{\"value\": \"My message\"}")
                        //Attribuer le token d'authentification dans un Cookie.
                        .cookie(new Cookie("AUTH_TOKEN", "TOKEN_SUPER_USER_VALUE")))
                //Assert la réponse.
                .andExpect(status().isOk())
                .andDo(print());
    }


*/
/*    @Test
    public void createUser() throws Exception {
        List<User> userList = userRepository.findAll();
        User user = userRepository.getById(6L);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken("userTOTO", "Totouser22@"));

        //SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);

        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/users")
                .header("authentication", "Bearer " + token)
                .content(asJsonString(userList))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").exists());
    }*//*




*/
/*    @Test
    @Order(1)
    public void createUserTest() {
        List<User> userList = userRepository.findAll();
        Boolean founded = false;
        String userName = "";
        for (User user: userList) {
            userName = user.getUsername();
            if (user.getId() == userId){
                founded = true;

            }
        }
        Assertions.assertTrue(founded == true,"Did not find the expected user in the userList");
        Assertions.assertEquals("userTOTO" , userName);

    }*//*


*/
/*    @Test
    @Order(3)
    //@WithMockUser(username = "userTOTO", password = "$2a$10$58LjxW9OYWGg6KaSRcsKEOuOkVkB7wn1nUMs7wGf9D041ayMOMmC2")
    public void loginAvailableForUserRegister() throws Exception {
        User testUser = userRepository.getById(6L);

        userRepository.save(testUser);
        String sessionattr = "userList";

        mockMvc.perform(get("/api/users")
                .param("username", testUser.getUsername())
                .param("password", testUser.getPassword())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    @Order(4)
    @WithMockUser(roles ="ADMIN")
    public void test() throws Exception {
        User testUser = userRepository.getById(6L);
        String userName = testUser.getUsername();
        String userPwd = testUser.getPassword();
        mockMvc.perform(get("/api/users/"))
                .login(userName, userPwd);
    }*//*


}
*/
