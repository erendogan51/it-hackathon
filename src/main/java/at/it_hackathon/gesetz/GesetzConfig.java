package at.it_hackathon.gesetz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GesetzConfig {



    @Bean
    CommandLineRunner commandLineRunnerGesetz(GesetzRepository repository){
        return args -> {
            Gesetz angG1 = new Gesetz(1, 1, "AngG", "An dem Tage, an dem dieses Gesetz in Wirksamkeit tritt, erlischt die Wirksamkeit des Gesetzes vom 16. Jänner 1910, RGBl. Nr. 20, über den Dienstvertrag der Handlungsgehilfen und anderer Dienstnehmer in ähnlicher Stellung (Handlungsgehilfengesetz) sowie die Wirksamkeit der Verordnung vom 22. März 1921, BGBl. Nr. 187, über die Beschränkung der Kündigung bestimmter Dienstverhältnisse. Gleichzeitig treten die §§ 201, 202, 203, 205 und 208 des allgemeinen Berggesetzes vom 23. Mai 1854, RGBl. Nr. 146, soweit sie sich auf Angestellte beziehen, außer Kraft.");
            Gesetz angG2 = new Gesetz(1, 2, "AngG", "(1) Dieses Bundesgesetz findet ferner Anwendung auf das Dienstverhältnis von Personen, die vorwiegend zur Leistungen kaufmännischer oder höherer, nicht kaufmännischer Dienste oder zu Kanzleiarbeiten im Geschäftsbetrieb von Unternehmungen, Anstalten oder sonstigen Dienstgebern der nachstehenden Art angestellt sind:\n" +
                    "\t\t\t\t\t\t\t\t\t\t\n" +
                    "\n" +
                    "1.\n" +
                    "\t\n" +
                    "\n" +
                    "In Unternehmungen jeder Art, auf welche die Gewerbeordnung Anwendung findet, ferner in Vereinen und Stiftungen jeder Art;\n" +
                    "\n" +
                    "2.\n" +
                    "\t\n" +
                    "\n" +
                    "in Kreditanstalten, Sparkassen, Vorschußkassen, Erwerbs- und Wirtschaftsgenossenschaften, Versatz-, Versorgungs- und Rentenanstalten, Krankenkassen, registrierten Hilfskassen, Versicherungsanstalten jeder Art, gleichviel, ob sie private Versicherungsgeschäfte betreiben oder den Zwecken der öffentlich-rechtlichen Versicherung dienen, sowie in Verbänden der genannten Anstalten;\n" +
                    "\n" +
                    "3.\n" +
                    "\t\n" +
                    "\n" +
                    "in der Schriftleitung, Verwaltung oder dem Verschleiß einer periodischen Druckschrift;\n" +
                    "\n" +
                    "4.\n" +
                    "\t\n" +
                    "\n" +
                    "in Kanzleien der Rechtsanwälte, Notare und Patentanwälte;\n" +
                    "\n" +
                    "5.\n" +
                    "\t\n" +
                    "\n" +
                    "bei Zivilingenieuren, nicht autorisierten Architekten und Zivilgeometern;\n" +
                    "\n" +
                    "6.\n" +
                    "\t\n" +
                    "\n" +
                    "in Tabaktrafiken und Lottokollekturen;\n" +
                    "\n" +
                    "7.\n" +
                    "\t\n" +
                    "\n" +
                    "bei Handelsmaklern, Privatgeschäftsvermittlungen und Auskunftsbüros;\n" +
                    "\n" +
                    "8.\n" +
                    "\t\n" +
                    "\n" +
                    "bei Ärzten, Zahntechnikern, in Privatheil- und -pflegeanstalten und in privaten Unterrichtsanstalten;\n" +
                    "\n" +
                    "9.\n" +
                    "\t\n" +
                    "\n" +
                    "im Bergbau auf vorbehaltene Mineralien einschließlich der auf Grund der Bergwerksverleihung (§ 131 des allgemeinen Berggesetzes vom 23. Mai 1854, RGBl. Nr. 146) errichteten Werksanlagen.\n" +
                    "\n" +
                    "(2) Nach Anhörung der Körperschaften, denen die Vertretung der in Betracht kommenden Interessen obliegt, kann mit Genehmigung des Hauptausschusses durch Verordnung die Anwendung dieses Gesetzes auch auf Angestellte bei anderen Dienstgebern ausgedehnt werden.");
            repository.saveAll(List.of(angG1,angG2));
        };
    }



}
