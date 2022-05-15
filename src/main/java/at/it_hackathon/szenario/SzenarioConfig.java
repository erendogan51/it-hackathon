package at.it_hackathon.szenario;

import at.it_hackathon.enums.Schwierigkeit;
import at.it_hackathon.frage.Frage;
import at.it_hackathon.frage.FrageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class SzenarioConfig {

//    Szenario szenario1 = new Szenario("SV-1",new HashSet<>());
//    Szenario szenario2 = Szenario.builder().
//            fragen(new HashSet<>())
//            .name("SV-2")
//            .absaetze(new HashSet<>(Set.of("A geht zu B..", "B macht daraufhin..", "A und B beschließen")))
//            .build();
//    Frage frage1 = new Frage("Was würdest du tun", Schwierigkeit.MITTEL, new HashSet<>(Set.of("Wegschauen", "Nichts Tun")), "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen");
//    Frage frage2 = new Frage("Was würdest du tun", Schwierigkeit.SCHWER, new HashSet<>(Set.of("Wegschauen", "Nichts Tun")), "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen");
//    Frage frage3 = new Frage("Was würdest du tun",Schwierigkeit.MITTEL, new HashSet<>(Set.of("Wegschauen", "Nichts Tun")), "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen");
//    Frage frage4 = new Frage("Was würdest du tun",Schwierigkeit.LEICHT,  new HashSet<>(Set.of("Wegschauen", "Nichts Tun")), "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen");
//    Frage frage5 = new Frage("Was würdest du tun",Schwierigkeit.LEICHT, new HashSet<>(Set.of("Wegschauen", "Nichts Tun")), "Sofort Melden", "Warten und mit meinen KollegenInnen besprechen");
//    @Bean
//    CommandLineRunner commandLineRunnerSzenario(SzenarioRepository szenarioRepository) {
//        return args -> {
//            szenarioRepository.saveAll(List.of(szenario1, szenario2));
//        };
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunnerFrage2(FrageRepository frageRepository) {
//        return args -> {
//            frageRepository.saveAll(List.of(frage1, frage2, frage3, frage4, frage5));
//        };
//    }
//
//    @Bean
//    CommandLineRunner commandLineRunnerSzenario2(SzenarioRepository szenarioRepository) {
//        return args -> {
//            szenario1.addListOfFragenToSzenario(List.of(frage1,frage3,frage4,frage5));
//            szenario2.addListOfFragenToSzenario(List.of(frage2));
//            szenarioRepository.saveAll(List.of(szenario1, szenario2));
//        };
//    }



}
