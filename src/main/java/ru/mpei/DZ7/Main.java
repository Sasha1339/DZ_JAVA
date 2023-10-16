package ru.mpei.DZ7;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Platform twitch = new Platform("Twitch", false);
        Platform youtube = new Platform("YouTube", false);
        Platform rutube = new Platform("RuTube", true);

        List<Streamer> streamers = new ArrayList<>(List.of(
                new Streamer("Alexander Kononov", 5, 22, 5, List.of(youtube)),
                new Streamer("Bratishkin", 4.8, 25, 200000, List.of(youtube, twitch)),
                new Streamer("Valera Gladiator", 5, 54, 1000000, List.of(youtube, twitch, rutube)),
                new Streamer("Kuplinov Play", 5, 50, 1000000, List.of(youtube, twitch, rutube)),
                new Streamer("Maslennikov", 4.5, 22, 5, List.of(youtube, rutube)),
                new Streamer("Java+", 5, 25, 5000000, List.of(youtube, twitch, rutube)),
                new Streamer("Viktor Tsoi", 5, 61, 5000000, List.of(youtube, twitch, rutube)),
                new Streamer("Alexander Malkov", 4.4, 45, 1250000, List.of(youtube, rutube)),
                new Streamer("Vladimir", 5, 70, 150000000, List.of(rutube)),
                new Streamer("Kukhnya onlain", 5, 30, 10000, List.of(rutube))
        ));


        /**
         * найти всех стримеров старше 21 года и с более 15к подписчиков на платформе twitch
         * */
        System.out.println("///////////////////////////////////////////////////////////////////////////////");

       streamers.stream()
                .filter(streamer -> streamer.getAge() > 21 && streamer.getSubscribes() > 15000)
                .filter(s -> !s.getPlatforms().stream()
                        .filter(p-> p.getName().equals(twitch.getName())).toList().isEmpty())
                .forEach(System.out::println);


        /**
         * найти самого молодого стримера на незаблокирвланной платформе
         * */
        System.out.println("///////////////////////////////////////////////////////////////////////////////");

        Streamer streamer = streamers.stream()
                .filter(s -> !s.getPlatforms().stream()
                        .filter(p->p.isRoscomnadzored()).toList().isEmpty())
                .sorted((s1, s2)-> s1.getAge() < s2.getAge() ? -1 : 1 )
                .findFirst().get();

        System.out.println(streamer.toString());

        /**
         * Получить Map<Name(string), PlatformName(String)> для всех стримеров
         * */
        System.out.println("///////////////////////////////////////////////////////////////////////////////");

        Map<String, String> maps =  streamers.stream()
                        .collect(Collectors.toMap(s -> s.getName(), s->s.getPlatforms().stream().map(p->p.getName()).toList().toString()));

        System.out.println(maps);

        System.out.println("///////////////////////////////////////////////////////////////////////////////");

        streamers.stream()
                        .flatMap(s -> s.getPlatforms().stream()
                                .map(p -> List.of(s.getName(), p.getName(), s.getPlatforms().indexOf(p))))
                                .collect(Collectors.toMap(s -> s.get(0)+"_"+s.get(2), s -> s.get(1)))
                .forEach((s, s2) -> System.out.println(s +" = "+ s2));


        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

        /**
         * Найти стримера с наименишм количествои подписчиков, который работает на заблокированной платформе
         * */

        Optional<Streamer> streamer1 = streamers.stream()
                .sorted((s1, s2) -> s1.getSubscribes()<s2.getSubscribes()? -1: 1)
                .filter(s -> !s.getPlatforms().stream().filter(p-> !p.isRoscomnadzored()).toList().isEmpty())
                .findFirst();

        System.out.println(streamer1);


        /**
         * вычислить средний возраст стримеров на платформе twitch
         */
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

        double averageAge = streamers.stream()
                .filter(s -> !s.getPlatforms().stream().filter(p -> p.getName().equals(twitch.getName())).toList().isEmpty())
                .mapToInt(s -> s.getAge())
                .summaryStatistics().getAverage();

        System.out.println(averageAge);
        /**
         * найти любого стримера на youtube c больше 10000, если нет бросисть NoSuchElementException
         */
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(streamers.stream()
                .filter(s -> s.getSubscribes() > 10000)
                .findAny().orElseThrow());

        /**
         * получить из листа стримеров лист платформ
         */
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

        List<List<String>> lists = streamers.stream()
                .map(s -> s.getPlatforms().stream().map(p->p.getName())
                        .toList())
                .toList();

        System.out.println(lists);

        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");

        Set<String> sets = streamers.stream()
                .flatMap(s -> s.getPlatforms().stream().
                        map(p -> p.getName()))
                .collect(Collectors.toSet());

        System.out.println(sets);

    }

}
