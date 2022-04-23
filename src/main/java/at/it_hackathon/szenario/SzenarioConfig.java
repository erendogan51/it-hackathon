package at.it_hackathon.szenario;

import at.it_hackathon.enums.Schwierigkeit;
import at.it_hackathon.frage.Frage;
import at.it_hackathon.frage.FrageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;

@Configuration
public class SzenarioConfig {

    Szenario szenario1 = new Szenario("SV-1",new HashSet<>(), Schwierigkeit.LEICHT);
    Szenario szenario2 = Szenario.builder().
            fragen(new HashSet<>())
            .name("SV-2")
            .schwierigkeit(Schwierigkeit.LEICHT)
            .absatz1("A geht zu B..")
            .absatz2("B macht daraufhin..")
            .absatz3("A und B beschließen")
            .build();
    Frage frage1 = new Frage("Was würdest du tun", "Wegschauen", "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen", szenario1);
    Frage frage2 = new Frage("Was würdest du tun", "Wegschauen", "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen", szenario2);

    @Bean
    CommandLineRunner commandLineRunnerSzenario(SzenarioRepository szenarioRepository) {
        return args -> {
            szenarioRepository.saveAll(List.of(szenario1, szenario2));
        };
    }

    @Bean
    CommandLineRunner commandLineRunnerFrage2(FrageRepository frageRepository) {
        return args -> {
            frageRepository.saveAll(List.of(frage1, frage2));
        };
    }

    @Bean
    CommandLineRunner commandLineRunnerSzenario2(SzenarioRepository szenarioRepository) {
        return args -> {
            szenario1.addListOfFragenToSzenario(List.of(frage1));
            szenario2.addListOfFragenToSzenario(List.of(frage2));
            szenarioRepository.saveAll(List.of(szenario1, szenario2));
        };
    }



}
