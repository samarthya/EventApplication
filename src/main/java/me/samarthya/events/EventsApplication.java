package me.samarthya.events;

import me.samarthya.events.dummy.DummyValues;
import me.samarthya.events.model.EventsModel;
import me.samarthya.events.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Annotates the class - SpringBootConfiguration, EnableAutoConfiguration, ComponentScan
 */
@SpringBootApplication
public class EventsApplication {
    private static final Logger logger = LoggerFactory.getLogger(EventsApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(EventsApplication.class, args);
    }


    @Bean
    public CommandLineRunner createDummyEvents(EventRepository eventRepository) {
        return (args) -> {


            logger.debug(" Welcome to the dummy events program");

            if (true) {
                DummyValues.dummyDataCreator(eventRepository);
            }

            for (EventsModel em : eventRepository.findAll()) {
                System.out.println("> " + em.toString());
            }
        };
    }
}
