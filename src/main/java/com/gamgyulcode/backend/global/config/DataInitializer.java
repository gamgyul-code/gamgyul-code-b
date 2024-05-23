package com.gamgyulcode.backend.global.config;

import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import com.gamgyulcode.backend.module.reading.domain.ReadingRepository;
import com.gamgyulcode.backend.module.reading.dto.ReadingResponse;
import com.gamgyulcode.backend.module.theme.domain.Theme;
import com.gamgyulcode.backend.module.theme.domain.ThemeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(ThemeRepository themeRepository, PlaceRepository placeRepository,
                                      ReadingRepository readingRepository) {
        return args -> {
            Theme theme1 = Theme.builder().themeName("설문대 할망").build();
            Theme theme2 = Theme.builder().themeName("역사").build();
            Theme theme3 = Theme.builder().themeName("신화").build();
            Theme theme4 = Theme.builder().themeName("사랑").build();

            themeRepository.save(theme1);
            themeRepository.save(theme2);
            themeRepository.save(theme3);
            themeRepository.save(theme4);

            // Create Place
            Place place1 = Place.builder().placeName("영실기암").placeAddress("제주 서귀포시 하원동 산1-4")
                    .locationX("33.3545211").locationY("126.498473")
                    .theme(theme1)
                    .build();

            Place place2 = Place.builder().placeName("한라산 국립공원").placeAddress("제주특별자치도 제주시 특별자치도, 1100로 2070-61")
                    .locationX("33.3917738").locationY("126.4945012")
                    .theme(theme1)
                    .build();

            placeRepository.save(place1);
            placeRepository.save(place2);
            theme1.getPlaces().add(place1);
            theme1.getPlaces().add(place2);
            themeRepository.save(theme1);

            // 읽을거리 추가


            Reading reading1 = Reading.builder()
                    .placeName("한라산 국립공원")
                    .phoneNumber("(+82) 064-713-9950")
                    .time("연중무휴")
                    .tale("옛날 옛적에 몸집이 아주 큰 설문대 할망이 있었다.\n"
                            + "설문대 할망은 힘 또한 장사였는데, 어느 날 치마폭에 흙을 가득 퍼 날라다 넓디넓은 푸른 바다 한가운데 붓기 시작했다.\n"
                            + "\n"
                            + "얼마나 부지런히 날라다 부었는지 바다 위로 섬의 형체가 만들어졌다. 저절로 만들어진 오름들이 보기 좋았는지, 설문대는 흙을 집어 섬 여기저기에 오름을 만들기 시작했다. 흙을 너무 많이 집어놓았다 싶은 것은 주먹으로 봉우리를 탁 쳐서 균형을 맞추었다. 봉우리가 움푹 파인 오름들은 그렇게 만들어진 것이라 한다. 드디어 섬 한가운데에 은하수를 만질 수 있을 만큼 높은 산이 만들어졌는데 이것이 바로 한라산이다.")
                    .terrain("지리산, 북한의 금강산과 함께 한반도의 3대 영산에 속하는 한라산은 한반도의 최남단에 위치하고 있으며, 높이 해발 1,950m로 남한에서 가장 높다.\n"
                            + "신생대 제4기의 젊은 화산섬인 한라산은 지금으로부터 2만 5천년 전까지 화산분화 활동을 하였으며, 한라산 주변에는 360여 개의 오름들이 분포되어 있어 특이한 경관을 창출하고 있다. 섬 중앙에 우뚝 솟은 한라산의 웅장한 자태는 자애로우면서도 강인한 기상을 가슴에 품고 있는 듯하다.")
                    .history("태고의 신비를 그대로 간직한 한라산과 아름다운 땅 제주는 신이 우리에게 선물한 최고의 보물이자 세계인이 함께 가꾸어야 할 소중한 유산으로 인정받아 2007년 6월 27일 제주 화산섬과 용암동굴이 우리나라 최초의 유네스코 세계자연유산으로 등재되었고, 2010년 10월 4일 세계지질공원으로 인증받았다.")
                    .caution("※ 청정 한라산 보전을 위해 일회용 도시락 반입 금지(김밥, 햄버거는 허용)")
                    .fee("free")
                    .introText("한라산은 최고야~ (수정필)")
                    .build();

            readingRepository.save(reading1);


        };
    }
}