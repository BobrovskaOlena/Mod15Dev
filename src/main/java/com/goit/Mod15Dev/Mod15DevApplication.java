package com.goit.Mod15Dev;

import com.goit.Mod15Dev.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Mod15DevApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Mod15DevApplication.class, args);
		NoteService noteService = context.getBean(NoteService.class);
	}
}