package com.coderhouse.controller;

import com.coderhouse.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coder-house")
@RequiredArgsConstructor
public class MensajesController {

    @GetMapping("/mensajes")
    public List<Message> todosLosMensajes() {
        return dataMensajes();
    }

    private List<Message> dataMensajes() {
        return List.of(
                Message.of(1L, "Mensaje-ABCD"),
                Message.of(2L, "Mensaje-ABCD"),
                Message.of(3L, "Mensaje-ABCD"),
                Message.of(4L, "Mensaje-ABCE"),
                Message.of(5L, "Mensaje-ABCF")
        );
    }
}