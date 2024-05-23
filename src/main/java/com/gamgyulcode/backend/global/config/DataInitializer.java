package com.gamgyulcode.backend.global.config;

import com.gamgyulcode.backend.module.entity.domain.Entities;
import com.gamgyulcode.backend.module.entity.domain.EntitiesRepository;
import com.gamgyulcode.backend.module.entity.domain.EntityType;
import com.gamgyulcode.backend.module.place.domain.Place;
import com.gamgyulcode.backend.module.place.domain.PlaceRepository;
import com.gamgyulcode.backend.module.reading.domain.Reading;
import com.gamgyulcode.backend.module.reading.domain.ReadingRepository;
import com.gamgyulcode.backend.module.reading.dto.ReadingResponse;
import com.gamgyulcode.backend.module.theme.domain.Theme;
import com.gamgyulcode.backend.module.theme.domain.ThemeRepository;
import com.gamgyulcode.backend.module.translation.domain.LanguageCode;
import com.gamgyulcode.backend.module.translation.domain.Translation;
import com.gamgyulcode.backend.module.translation.domain.TranslationRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(ThemeRepository themeRepository, PlaceRepository placeRepository,
                                      ReadingRepository readingRepository, TranslationRepository translationRepository,
                                      EntitiesRepository entitiesRepository) {
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

            Place place3 = Place.builder()
                    .placeName("제주 돌문화공원")
                    .placeAddress("제주특별자치도 제주시 조천읍 남조로 2023")
                    .locationX("33.4373391").locationY("126.6668484")
                    .theme(theme1)
                    .build();

            Place place4 = Place.builder()
                    .placeName("고근산")
                    .placeAddress("제주특별자치도 서귀포시 고근산로202번길 48")
                    .locationX("33.2707366").locationY("126.5126032")
                    .theme(theme1)
                    .build();

            Place place5 = Place.builder()
                    .placeName("당케포구")
                    .placeAddress("제주특별자치도 서귀포시 표선면 표선리 1-3")
                    .locationX("33.3264171").locationY("126.8468674")
                    .theme(theme1)
                    .build();



            placeRepository.save(place1);
            placeRepository.save(place2);
            placeRepository.save(place3);
            placeRepository.save(place4);
            placeRepository.save(place5);
            theme1.getPlaces().add(place1);
            theme1.getPlaces().add(place2);
            theme1.getPlaces().add(place3);
            theme1.getPlaces().add(place4);
            theme1.getPlaces().add(place5);
            themeRepository.save(theme1);

            // 읽을거리 추가

            Reading reading1 = Reading.builder()
                    .readingPlaceName("영실기암")
                    .placePictureUrl("https://api.cdn.visitjeju.net/photomng/imgpath/201910/01/b5e8fc43-37fa-4b8d-ac44-19e8bf04a4ca.jpg")
                    .time("연중무휴")
                    .tale("제주를 만들었다는 거대 설문대할망에게는 오백 아들들이 있었다. 어느 날 아들들이 나무를 하러 나가고, 저녁 때가 되어 설문대할망은 오백 아들이 먹을 죽을 아주 큰 가마솥에 쑤고 있는데 그만 죽을 젓다가 그 솥에 빠져 죽고 만다. "
                            + "하루의 고된 삶을 마치고 집에 돌아온 오백 아들들은 배가 고파 그 죽을 아주 맛있게 먹었다. 어머니가 빠져 죽은 죽이란 걸 까마득히 모른 채."
                            + " 막내아들이 먹을 때 쯤 죽의 밑바닥에 있는 뼈를 발견하고는 그제서야 자신들의 어머니가 그 솥에 빠져 죽은 사실을 알게 된다. 499명의 아들들은 슬피 울다 영실계곡의 돌이 되었다 하고 막내아들은 어머니의 육신을 먹은 형들과는 같이 있을 수 없다고 뛰쳐나가 현재의 차귀도에 돌이 되어 마지막 장군석으로 서 있다고 한다.")
                    .fee("무료")
                    .introText("영실기암 한줄소개")
                    .build();


            Reading reading2 = Reading.builder()
                    .readingPlaceName("한라산 국립공원")
                    .placePictureUrl("https://api.cdn.visitjeju.net/photomng/imgpath/201911/29/48bdb99e-20ba-4fb6-82f2-6ea79ceefb0d.jpg")
                    .phoneNumber("(+82) 064-713-9950")
                    .time("연중무휴")
                    .tale("옛날 옛적에 몸집이 아주 큰 설문대 할망이 있었다."
                            + "설문대 할망은 힘 또한 장사였는데, 어느 날 치마폭에 흙을 가득 퍼 날라다 넓디넓은 푸른 바다 한가운데 붓기 시작했다."
                            + "얼마나 부지런히 날라다 부었는지 바다 위로 섬의 형체가 만들어졌다. 저절로 만들어진 오름들이 보기 좋았는지, 설문대는 흙을 집어 섬 여기저기에 오름을 만들기 시작했다. 흙을 너무 많이 집어놓았다 싶은 것은 주먹으로 봉우리를 탁 쳐서 균형을 맞추었다. 봉우리가 움푹 파인 오름들은 그렇게 만들어진 것이라 한다. 드디어 섬 한가운데에 은하수를 만질 수 있을 만큼 높은 산이 만들어졌는데 이것이 바로 한라산이다.")
                    .terrain("지리산, 북한의 금강산과 함께 한반도의 3대 영산에 속하는 한라산은 한반도의 최남단에 위치하고 있으며, 높이 해발 1,950m로 남한에서 가장 높다."
                            + "신생대 제4기의 젊은 화산섬인 한라산은 지금으로부터 2만 5천년 전까지 화산분화 활동을 하였으며, 한라산 주변에는 360여 개의 오름들이 분포되어 있어 특이한 경관을 창출하고 있다. 섬 중앙에 우뚝 솟은 한라산의 웅장한 자태는 자애로우면서도 강인한 기상을 가슴에 품고 있는 듯하다.")
                    .history("태고의 신비를 그대로 간직한 한라산과 아름다운 땅 제주는 신이 우리에게 선물한 최고의 보물이자 세계인이 함께 가꾸어야 할 소중한 유산으로 인정받아 2007년 6월 27일 제주 화산섬과 용암동굴이 우리나라 최초의 유네스코 세계자연유산으로 등재되었고, 2010년 10월 4일 세계지질공원으로 인증받았다.")
                    .caution("※ 청정 한라산 보전을 위해 일회용 도시락 반입 금지(김밥, 햄버거는 허용)")
                    .fee("무료")
                    .introText("한반도의 3대 영산에 속하는 한라산은 남한에서 가장 높은 산이다. 설문대할망이 만들었다는 전설이 전해지는 한라산의 이야기는?")
                    .build();

            Reading reading3 = Reading.builder()
                    .readingPlaceName("제주 돌문화공원")
                    .placePictureUrl("https://api.cdn.visitjeju.net/photomng/imgpath/202111/01/c1fca31b-5bb2-453d-a818-b473ae2d0988.jpg")
                    .phoneNumber("(+82) 064-710-7731~3")
                    .time("평일 : 09:00 ~ 18:00 , 주말 : 09:00 ~ 18:00")
                    .tale("제주돌문화공원은 돌의 고향인 제주도의 전신과 체계적인 돌 문화를 보여 주는 박물관이자 생태 공원이다."
                            + " 제주도의 모든 석상들을 다 전시해 놓았을 정도로 규모가 방대하며, 공원 전체가 제주도의 탄생 신화인 설문대할망과 오백장군을 테마로 조성되어 있어서, 고즈넉한 제주 산간의 분위기를 느끼는데 더할 나위 없는 장소다."
                            + "설문대할망의 설화를 따라간다면, 해당 설화를 이해하는 데 가장 최적의 장소이다.")
                    .fee("유료,입장료 : 성인 5,000원, 청소년 3,500원, 어린이.경로인.장애인 무료")
                    .introText("설문대할망과 오백장군을 테마로 조성된 공원. 제주도의 모든 석상을 전시해 놓을 정도로 방대한 규모이다. 이 곳에서 설문대할망의 비밀을 많이 파헤칠 수 있을지도?")
                    .build();

            Reading reading4 = Reading.builder()
                    .readingPlaceName("고근산")
                    .placePictureUrl("https://api.cdn.visitjeju.net/photomng/imgpath/201804/30/4f77f379-2304-44d1-b319-8cd86241cd93.jpg")
                    .phoneNumber("(+82) 064-760-2913")
                    .time("연중무휴")
                    .tale("고근산은 고공산이라고도 불리는데, 평지 한가운데가 우뚝 솟은 오름이라고 해서 붙여진 이름이라는 설과 근처에 산이 없어 외롭다는 데서 유래됐다는 설이 있다."
                            + "이 오름은 설문대할망이 심심할 때면 한라선 정상부를 베개 삼고 고근산 굼부리에는 궁둥이를 얹고 앞바다 범섬에 다리를 걸치고 누워서 물장구를 쳤다는 전설이 있다.")
                    .terrain("제주올레 7-1코스 중간 지점에 위치한 고근산(孤根山)은 서귀포 신시가지를 감싸고 있는 오름으로 정상에 깊지 않은 분화구를 가지고 있다. "
                            + "오름 중턱에는 삼나무, 편백나무, 상수리나무 등이 조림되어 있는데 나무들이 토해내는 상쾌한 공기를 마시며 오르다 보면 분화구에 도착한다. 이 곳에서 범섬 앞바다가 한눈에 펼쳐지고 서귀포시의 모습이 잘 드러난다.")
                    .caution("오름은 주소가 산지로 되어있어, 내비게이션 검색시 정확한 위치를 알 수 없거나, 주차장이 따로 없는 곳이 많다."
                            + "또한 일부 오름은 사유지로, 출입이 제한되거나 통제되어있는 곳도 있다."
                            + "이에, 오름 방문시에는 사전에 제주관광정보센터(064-740-6000) 등을 통해 정확한 정보를 확인하고 방문하길 바란다.")
                    .fee("무료")
                    .introText("설문대할망이 누웠다고 전해지는 고근산. 아름다운 범섬을 한눈에 볼 수 있는 곳이다.")
                    .build();

            Reading reading5 = Reading.builder()
                    .readingPlaceName("당케포구")
                    .placePictureUrl("https://api.cdn.visitjeju.net/photomng/imgpath/202112/20/4b201f05-0d00-40b5-b1e3-d7f634cf17a4.JPG")
                    .time("연중무휴")
                    .tale("당케는 ‘당이 있는 케(경작지)’라는 의미인데 여기서 ‘당’은 ‘할망당’을 가리키며, 제주의 창조신인 ‘설문대할망’에게 넋을 기리는 곳이다. 예부터 표선 앞바다는 수심이 깊어 폭우가 몰아치면 파도가 마을을 쑥대밭으로 만들곤 하였다. "
                            + "이에 고난을 겪던 마을 주민들이 신에게 소원을 빌자 하루 사이에 바다를 메운 포구가 만들어졌다는 전설이 전해져 오는데, 이를 ‘당케할망의전설’ 이라고 한다."
                            + "포구와 가까이 위치한 할망당에는 위패가 모셔져 있는데 주로 해녀들이 오고 가며 신에게 제를 지내곤 한다. 할망당은 항상 열려 있으니 누구든지 언제라도 방문하여 제를 올릴 수 있다.")
                    .history("올레 4코스 출발지점에 위치해 있는 당케포구는 제주에서 가장 넓은 면적의 백사장인 표선 해비치 해변에 있는 포구이다. "
                            + "조선시대부터 어업과 무역이 이루어지면서 일제강점기 이후에는 포구에 마을이 형성되었으며, 당케포구의 백사장에서 성산일출봉 방향으로 바라보면 표선해변과 당케마을이 보인다.")
                    .fee("무료")
                    .introText("등대와 어우러진 바다 풍경과 간혹 드나드는 통통배가 멋진 풍광을 자아내는 해돋이 명소 이 곳에 숨겨진 설문대할망의 이야기는?")
                    .build();

            readingRepository.save(reading1);
            readingRepository.save(reading2);
            readingRepository.save(reading3);
            readingRepository.save(reading4);
            readingRepository.save(reading5);

            Entities placeEntity = Entities.builder()
                    .entityName("place")
                    .entityType(EntityType.PLACE)
                    .build();

            Entities readingEntity = Entities.builder()
                    .entityName("reading")
                    .entityType(EntityType.READING)
                    .build();

            entitiesRepository.save(placeEntity);
            entitiesRepository.save(readingEntity);



            List<Translation> translations = Arrays.asList(
                    Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("readingPlaceName")
                    .languageCode(LanguageCode.EN)
                    .text("Yeongsilgi Rock")
                    .entityId(reading1.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("time")
                    .languageCode(LanguageCode.EN)
                    .text("24/7")
                    .entityId(reading1.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("tale")
                    .languageCode(LanguageCode.EN)
                    .text("The giant Seolmundae Halmang, who is said to have created Jeju, had five hundred sons. One day, while her sons were out gathering wood, Seolmundae Halmang was cooking a large pot of porridge for them. Unfortunately, she fell into the pot and drowned. When the sons returned home tired and hungry, they ate the porridge without knowing their mother was in it. The youngest son discovered bones at the bottom of the pot and realized what had happened. The 499 sons wept bitterly and turned into stones in the Yeongsil Valley. The youngest son, unable to stay with his brothers who had consumed their mother, ran away and became a stone at Chagwido, now known as the Last General's Stone.")
                    .entityId(reading1.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("fee")
                    .languageCode(LanguageCode.EN)
                    .text("Free")
                    .entityId(reading1.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("introText")
                    .languageCode(LanguageCode.EN)
                    .text("A brief introduction to Yeongsilgi Rock")
                    .entityId(reading1.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("readingPlaceName")
                    .languageCode(LanguageCode.EN)
                    .text("Hallasan National Park")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("time")
                    .languageCode(LanguageCode.EN)
                    .text("24/7")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("tale")
                    .languageCode(LanguageCode.EN)
                    .text("Once upon a time, there was a giant named Seolmundae Halmang. She was incredibly strong and carried dirt in her skirt to form a large island in the middle of the vast blue sea. She formed mountains all over the island by piling dirt, and if a pile seemed too high, she would punch it to balance it. The mountains with depressions at the top are said to be formed this way. Eventually, she created a mountain high enough to touch the Milky Way, which is Hallasan.")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("terrain")
                    .languageCode(LanguageCode.EN)
                    .text("Hallasan, one of Korea's three major mountains along with Jirisan and Geumgangsan in North Korea, is located at the southernmost tip of the Korean Peninsula. It stands at 1,950 meters above sea level, making it the highest mountain in South Korea. A young volcanic island from the Quaternary period of the Cenozoic era, Hallasan last erupted about 25,000 years ago. It is surrounded by 360 parasitic cones, creating a unique landscape. The majestic appearance of Hallasan, rising in the center of the island, exudes a sense of grace and strength.")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("history")
                    .languageCode(LanguageCode.EN)
                    .text("Recognized as the greatest gift from the gods and a precious heritage to be preserved by the world, Jeju's Hallasan and its beautiful land were inscribed as Korea's first UNESCO World Natural Heritage site on June 27, 2007, and were designated as a Global Geopark on October 4, 2010.")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("caution")
                    .languageCode(LanguageCode.EN)
                    .text("※ To preserve the pristine condition of Hallasan, disposable lunch containers are prohibited (kimbap and hamburgers are allowed).")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("fee")
                    .languageCode(LanguageCode.EN)
                    .text("Free")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("introText")
                    .languageCode(LanguageCode.EN)
                    .text("Hallasan, one of Korea's three major mountains, is the highest mountain in South Korea. What is the legend of Hallasan created by Seolmundae Halmang?")
                    .entityId(reading2.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("readingPlaceName")
                    .languageCode(LanguageCode.EN)
                    .text("Jeju Stone Park")
                    .entityId(reading3.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("time")
                    .languageCode(LanguageCode.EN)
                    .text("Weekdays: 09:00 ~ 18:00, Weekends: 09:00 ~ 18:00")
                    .entityId(reading3.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("tale")
                    .languageCode(LanguageCode.EN)
                    .text("Jeju Stone Park is a museum and ecological park that showcases the comprehensive stone culture of Jeju Island, the home of stones. The park is extensive, displaying all the stone statues of Jeju, and is themed around the island's creation myth of Seolmundae Halmang and her five hundred generals. It's an ideal place to explore and understand the myth while experiencing the serene mountain atmosphere of Jeju.")
                    .entityId(reading3.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("fee")
                    .languageCode(LanguageCode.EN)
                    .text("Paid, Admission: Adults 5,000 KRW, Youth 3,500 KRW, Free for children, seniors, and people with disabilities")
                    .entityId(reading3.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("introText")
                    .languageCode(LanguageCode.EN)
                    .text("Jeju Stone Park is themed around Seolmundae Halmang and her five hundred generals. It's an extensive park displaying all the stone statues of Jeju. This place could reveal many secrets about Seolmundae Halmang!")
                    .entityId(reading3.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("readingPlaceName")
                    .languageCode(LanguageCode.EN)
                    .text("Gogeunsan")
                    .entityId(reading4.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("time")
                    .languageCode(LanguageCode.EN)
                    .text("24/7")
                    .entityId(reading4.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("tale")
                    .languageCode(LanguageCode.EN)
                    .text("Gogeunsan, also known as Gogongsan, is said to have earned its name because it stands alone in the middle of the plains, or because it's lonely without nearby mountains. Legend has it that when Seolmundae Halmang was bored, she would use Hallasan's summit as a pillow, sit on Gogeunsan's crater, and stretch her legs to play in the waters of the nearby Beomseom.")
                    .entityId(reading4.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("terrain")
                    .languageCode(LanguageCode.EN)
                    .text("Gogeunsan, located in the middle of Olle Trail 7-1, is a crater-topped oreum that surrounds the new city of Seogwipo. The midsection of the oreum is planted with cedar, cypress, and oak trees, offering refreshing air as you climb. From the crater, you can see the vast sea around Beomseom and the cityscape of Seogwipo.")
                    .entityId(reading4.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("caution")
                    .languageCode(LanguageCode.EN)
                    .text("Many oreums are registered as mountainous regions, making it hard to pinpoint their exact locations on navigation systems. Some have no dedicated parking, and some are private property with restricted access. It's advised to check accurate information with the Jeju Tourism Information Center (064-740-6000) before visiting.")
                    .entityId(reading4.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("fee")
                    .languageCode(LanguageCode.EN)
                    .text("Free")
                    .entityId(reading4.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("introText")
                    .languageCode(LanguageCode.EN)
                    .text("Gogeunsan, where Seolmundae Halmang is said to have laid down. You can enjoy a panoramic view of Beomseom from here.")
                    .entityId(reading4.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("readingPlaceName")
                    .languageCode(LanguageCode.EN)
                    .text("Dangke Port")
                    .entityId(reading5.getId())
                    .build(),
                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.EN)
                            .text("Gogeunsan")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.EN)
                            .text("Jeju Stone Park")
                            .entityId(reading3.getId())
                            .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("time")
                    .languageCode(LanguageCode.EN)
                    .text("24/7")
                    .entityId(reading5.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("tale")
                    .languageCode(LanguageCode.EN)
                    .text("Dangke means 'field with a shrine,' referring to the shrine for Seolmundae Halmang, the creator goddess of Jeju. The sea in front of Pyoseon was once very deep, and storms would often wreak havoc on the village. After villagers prayed for relief, the port was created overnight, according to the legend of Dangke Halmang. Close to the port, there is a shrine where divers often stop to perform rituals. The shrine is always open, allowing anyone to visit and offer prayers at any time.")
                    .entityId(reading5.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("history")
                    .languageCode(LanguageCode.EN)
                    .text("Located at the starting point of Olle Trail 4, Dangke Port is part of Pyoseon Beach, which has the largest white sand beach area in Jeju. Since the Joseon Dynasty, the port has been a hub for fishing and trade, and a village formed around it during the Japanese occupation. From the beach at Dangke Port, you can see Pyoseon Beach and Dangke Village towards Seongsan Ilchulbong.")
                    .entityId(reading5.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("fee")
                    .languageCode(LanguageCode.EN)
                    .text("Free")
                    .entityId(reading5.getId())
                    .build(),

            Translation.builder()
                    .entityType(EntityType.READING)
                    .fieldName("introText")
                    .languageCode(LanguageCode.EN)
                    .text("A sunrise spot with a lighthouse, blending with the sea and occasional small boats. What hidden stories of Seolmundae Halmang can you discover here?")
                    .entityId(reading5.getId())
                    .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.EN)
                            .text("1-4, Hawon-dong, Seogwipo-si, Jeju")
                            .entityId(place1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.EN)
                            .text("2070-61, 1100-ro, Jeju-si, Jeju Special Self-Governing Province")
                            .entityId(place2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.EN)
                            .text("2023, Namjo-ro, Jocheon-eup, Jeju-si, Jeju Special Self-Governing Province")
                            .entityId(place3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.EN)
                            .text("48, Gogeunsan-ro 202beon-gil, Seogwipo-si, Jeju Special Self-Governing Province")
                            .entityId(place4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.EN)
                            .text("1-3, Pyoseon-ri, Pyoseon-myeon, Seogwipo-si, Jeju Special Self-Governing Province")
                            .entityId(place5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.EN)
                            .text("Yeongsilgi Rock")
                            .entityId(place1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.EN)
                            .text("Hallasan National Park")
                            .entityId(place2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.EN)
                            .text("Dangke Port")
                            .entityId(place5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.EN)
                            .text("Gogeunsan")
                            .entityId(place4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.EN)
                            .text("Jeju Stone Park")
                            .entityId(place3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.CN)
                            .text("灵室奇岩")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.CN)
                            .text("全天开放")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.CN)
                            .text("据说创立济州的巨人雪妍德哈尔玛有五百个儿子。有一天，当她的儿子们外出砍柴时，雪妍德哈尔玛为他们煮了一大锅粥。不幸的是，她掉进了锅里淹死了。儿子们回到家后又累又饿，不知道母亲在里面，就吃了粥。最小的儿子在锅底发现了骨头，意识到发生了什么事。499个儿子痛哭不已，变成了灵室谷中的石头。最小的儿子因无法与吃了母亲的兄弟们在一起，逃到了现在被称为“最后将军石”的茶桂岛上，变成了一块石头。")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.CN)
                            .text("免费")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.CN)
                            .text("灵室奇岩的简要介绍")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.CN)
                            .text("汉拿山国家公园")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.CN)
                            .text("全天开放")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.CN)
                            .text("很久以前，有一个叫雪妍德哈尔玛的巨人。她力大无比，用裙子装土在广阔的蓝色海洋中间形成了一个大岛。她在岛上堆土形成了山，如果堆得太高，她会拳打这些土堆来保持平衡。据说顶端有凹陷的山就是这样形成的。最终，她创造了一座高到可以触及银河的山，这就是汉拿山。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("terrain")
                            .languageCode(LanguageCode.CN)
                            .text("汉拿山是韩国三大名山之一，与智异山和北朝鲜的金刚山并列，位于朝鲜半岛的最南端。它海拔1950米，是韩国最高的山。汉拿山是新生代第四纪的年轻火山岛，约25000年前最后一次喷发。它周围环绕着360个寄生锥，形成了独特的景观。矗立在岛中央的汉拿山雄伟壮丽，展现出一种优雅和力量。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("history")
                            .languageCode(LanguageCode.CN)
                            .text("汉拿山和济州的美丽土地被认为是神灵的最大礼物和世界应保护的珍贵遗产，于2007年6月27日被列为韩国首个联合国教科文组织世界自然遗产，并于2010年10月4日被指定为全球地质公园。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("caution")
                            .languageCode(LanguageCode.CN)
                            .text("※ 为了保护汉拿山的原始状态，禁止使用一次性午餐容器（允许使用紫菜包饭和汉堡）。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.CN)
                            .text("免费")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.CN)
                            .text("汉拿山是韩国三大名山之一，是韩国最高的山。雪妍德哈尔玛创立汉拿山的传说是什么？")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.CN)
                            .text("济州石公园")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.CN)
                            .text("平日：09:00 ~ 18:00，周末：09:00 ~ 18:00")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.CN)
                            .text("济州石公园是一个展示济州岛全面石文化的博物馆和生态公园。公园非常广阔，展示了济州所有的石像，并以雪妍德哈尔玛和她的五百将军的创世神话为主题。这里是探索和了解神话，同时体验济州宁静山景的理想场所。")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.CN)
                            .text("收费，门票：成人5000韩元，青少年3500韩元，儿童、老人和残疾人免费")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.CN)
                            .text("济州石公园以雪妍德哈尔玛和她的五百将军为主题。它是一个展示济州所有石像的广阔公园。这个地方可以揭示很多关于雪妍德哈尔玛的秘密！")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.CN)
                            .text("古根山")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.CN)
                            .text("全天开放")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.CN)
                            .text("古根山，也被称为孤宫山，据说因为它独自矗立在平原中间，或因为没有附近的山而显得孤单。传说雪妍德哈尔玛无聊时，会用汉拿山的山顶作为枕头，坐在古根山的火山口上，伸腿在附近的虎岛水域玩耍。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("terrain")
                            .languageCode(LanguageCode.CN)
                            .text("古根山位于奥勒步道7-1的中间，是一个顶部有火山口的乌尔姆，环绕着新的西归浦市。乌尔姆的中部种植了雪松、柏树和橡树，爬上去时空气清新。从火山口可以看到虎岛周围的广阔海域和西归浦的城市景观。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("caution")
                            .languageCode(LanguageCode.CN)
                            .text("许多乌尔姆被注册为山区，难以在导航系统上精确定位。有些没有专门的停车场，有些是私人财产，禁止进入。建议在访问前向济州旅游信息中心（064-740-6000）确认准确信息。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.CN)
                            .text("免费")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.CN)
                            .text("传说雪妍德哈尔玛曾在古根山躺下。你可以在这里欣赏到虎岛的全景。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.CN)
                            .text("唐克港")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.CN)
                            .text("全天开放")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.CN)
                            .text("唐克意为“有神庙的田地”，指的是济州创世女神雪妍德哈尔玛的神庙。表善前面的海域曾经很深，暴风雨经常给村庄带来灾难。村民们祈求帮助后，唐克港一夜之间建成了。据传这是唐克哈尔玛的传说。港口附近有一座神庙，潜水员经常在此举行仪式。神庙始终开放，任何人都可以随时前来祈祷。")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("history")
                            .languageCode(LanguageCode.CN)
                            .text("唐克港位于奥勒步道4的起点，是表善海滩的一部分，表善海滩是济州最大的白沙滩。自朝鲜王朝以来，该港一直是渔业和贸易的中心，日据时期形成了一个村庄。从唐克港的沙滩可以看到表善海滩和唐克村，面向城山日出峰。")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.CN)
                            .text("免费")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.CN)
                            .text("这是一个有灯塔的日出景点，与大海和偶尔出没的小船融为一体。在这里你能发现雪妍德哈尔玛的哪些隐藏故事？")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.CN)
                            .text("济州市西归浦市河源洞1-4")
                            .entityId(place1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.CN)
                            .text("济州市1100路2070-61号，济州特别自治道")
                            .entityId(place2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.CN)
                            .text("济州市朝天邑南路2023号，济州特别自治道")
                            .entityId(place3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.CN)
                            .text("济州市西归浦市古根山路202号48号，济州特别自治道")
                            .entityId(place4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.CN)
                            .text("济州市西归浦市表善面表善里1-3号，济州特别自治道")
                            .entityId(place5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.CN)
                            .text("灵室奇岩")
                            .entityId(place1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.CN)
                            .text("汉拿山国家公园")
                            .entityId(place2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.CN)
                            .text("济州石公园")
                            .entityId(place3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.CN)
                            .text("古根山")
                            .entityId(place4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.CN)
                            .text("唐克港")
                            .entityId(place5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.JP)
                            .text("ヨンシル奇岩")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.JP)
                            .text("24時間営業")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.JP)
                            .text("済州を創ったとされる巨人ソルムンダエハルマンには五百人の息子がいました。ある日、息子たちが薪を集めに出かけている間に、ソルムンダエハルマンは彼らのために大きな鍋で粥を作っていました。不運にも、彼女は鍋に落ちて溺れました。息子たちが家に帰ると疲れて空腹だったため、母親が中にいることを知らずに粥を食べました。末っ子が鍋の底で骨を見つけ、何が起こったかに気づきました。499人の息子たちは悲しみのあまり泣き崩れ、ヨンシル渓谷の石になりました。末っ子は母親を食べてしまった兄弟たちと一緒にいられず、チャグイドに逃げて「最後の将軍の石」として知られる石になりました。")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.JP)
                            .text("無料")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.JP)
                            .text("ヨンシル奇岩の簡単な紹介")
                            .entityId(reading1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.JP)
                            .text("漢拏山国立公園")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.JP)
                            .text("24時間営業")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.JP)
                            .text("昔々、ソルムンダエハルマンという名前の巨人がいました。彼女は非常に力が強く、スカートに土を入れて広大な青い海の真ん中に大きな島を作りました。彼女は島のあちこちに土を積んで山を作り、もし積みすぎた場合はそれを拳で叩いてバランスを取るようにしました。頂上にくぼみがある山はこのようにして形成されたとされています。最終的に、彼女は銀河に手が届くほど高い山を作り上げました。それが漢拏山です。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("terrain")
                            .languageCode(LanguageCode.JP)
                            .text("漢拏山は韓国の三大名山の一つであり、智異山および北朝鮮の金剛山と並び、朝鮮半島の最南端に位置しています。海抜1950メートルで、韓国で最も高い山です。漢拏山は新生代第四紀の若い火山島で、約25000年前に最後に噴火しました。その周りには360の寄生火山があり、独特の景観を作り出しています。島の中央にそびえる雄大な漢拏山は、優雅さと力強さを備えています。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("history")
                            .languageCode(LanguageCode.JP)
                            .text("漢拏山と済州の美しい土地は、神々からの最高の贈り物であり、世界が保存すべき貴重な遺産として認められ、2007年6月27日に韓国初のユネスコ世界自然遺産に登録され、2010年10月4日にグローバルジオパークに指定されました。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("caution")
                            .languageCode(LanguageCode.JP)
                            .text("※ 漢拏山の清潔な状態を保つために、使い捨てランチボックスは禁止されています（海苔巻きとハンバーガーは許可されています）。")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.JP)
                            .text("無料")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.JP)
                            .text("漢拏山は韓国の三大名山の一つで、韓国で最も高い山です。ソルムンダエハルマンが創った漢拏山の伝説とは？")
                            .entityId(reading2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.JP)
                            .text("済州石公園")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.JP)
                            .text("平日：09:00〜18:00、週末：09:00〜18:00")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.JP)
                            .text("済州石公園は、石のふるさとである済州島の全面的な石文化を展示する博物館および生態公園です。公園は広大で、済州のすべての石像を展示しており、島の創世神話であるソルムンダエハルマンと彼女の五百将軍をテーマにしています。ここは、神話を探索し理解するのに最適な場所であり、済州の静かな山の雰囲気を体験できます。")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.JP)
                            .text("有料、入場料：大人5000ウォン、青少年3500ウォン、子供、シニア、障害者は無料")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.JP)
                            .text("済州石公園は、ソルムンダエハルマンと彼女の五百将軍をテーマにしています。広大な公園で、済州のすべての石像を展示しています。この場所は、ソルムンダエハルマンの多くの秘密を明らかにするかもしれません！")
                            .entityId(reading3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.JP)
                            .text("古根山")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.JP)
                            .text("24時間営業")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.JP)
                            .text("古根山は孤根山とも呼ばれ、その名は平野の真ん中に一つだけ立っているため、あるいは近くに山がなく孤立しているためだと言われています。伝説によれば、ソルムンダエハルマンは暇なときに漢拏山の山頂を枕にし、古根山の火口に腰を下ろし、足を伸ばして近くの虎島の水で遊んだと言われています。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("terrain")
                            .languageCode(LanguageCode.JP)
                            .text("古根山はオルレ7-1コースの中間地点にあり、新しい西帰浦市を囲む火口を持つオルムです。オルムの中腹にはスギ、ヒノキ、ナラの木が植えられており、登るときには新鮮な空気を楽しむことができます。火口からは、虎島周辺の広大な海と西帰浦市の景色が一望できます。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("caution")
                            .languageCode(LanguageCode.JP)
                            .text("多くのオルムは山岳地帯として登録されており、ナビゲーションシステムで正確な位置を特定するのが難しいです。一部には専用の駐車場がなく、また一部は私有地で立ち入り禁止です。訪問前に済州観光情報センター（064-740-6000）で正確な情報を確認することをお勧めします。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.JP)
                            .text("無料")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.JP)
                            .text("ソルムンダエハルマンが古根山に横たわっていたと言われています。ここから虎島の全景を楽しむことができます。")
                            .entityId(reading4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("readingPlaceName")
                            .languageCode(LanguageCode.JP)
                            .text("タンケ港")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("time")
                            .languageCode(LanguageCode.JP)
                            .text("24時間営業")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("tale")
                            .languageCode(LanguageCode.JP)
                            .text("タンケは“神社のある田”を意味し、済州の創世女神であるソルムンダエハルマンの神社を指します。表善の前の海はかつて非常に深く、暴風雨が村に大きな被害をもたらしました。村人たちが救済を祈ると、タンケ港は一夜にして造られたと伝えられています。港の近くには神社があり、ダイバーがよく儀式を行います。神社はいつでも開放されており、誰でもいつでも訪れて祈ることができます。")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("history")
                            .languageCode(LanguageCode.JP)
                            .text("タンケ港はオルレ4コースの出発点に位置し、済州で最も広い白砂のビーチである表善ビーチの一部です。朝鮮時代から漁業と貿易の中心地であり、日本統治時代には港周辺に村が形成されました。タンケ港のビーチからは表善ビーチとタンケ村を城山日出峰方向に見ることができます。")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("fee")
                            .languageCode(LanguageCode.JP)
                            .text("無料")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.READING)
                            .fieldName("introText")
                            .languageCode(LanguageCode.JP)
                            .text("灯台と調和した日の出スポットで、海と時折出没する小船と一体化しています。ここでソルムンダエハルマンの隠された物語を発見できますか？")
                            .entityId(reading5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.JP)
                            .text("済州市西帰浦市河源洞1-4")
                            .entityId(place1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.JP)
                            .text("済州市1100路2070-61号，済州特別自治道")
                            .entityId(place2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.JP)
                            .text("済州市朝天邑南路2023号，済州特別自治道")
                            .entityId(place3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.JP)
                            .text("済州市西帰浦市古根山路202号48号，済州特別自治道")
                            .entityId(place4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeAddress")
                            .languageCode(LanguageCode.JP)
                            .text("済州市西帰浦市表善面表善里1-3号，済州特別自治道")
                            .entityId(place5.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.JP)
                            .text("ヨンシル奇岩")
                            .entityId(place1.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.JP)
                            .text("漢拏山国立公園")
                            .entityId(place2.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.JP)
                            .text("済州石公園")
                            .entityId(place3.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.JP)
                            .text("古根山")
                            .entityId(place4.getId())
                            .build(),

                    Translation.builder()
                            .entityType(EntityType.PLACE)
                            .fieldName("placeName")
                            .languageCode(LanguageCode.JP)
                            .text("タンケ港")
                            .entityId(place5.getId())
                            .build()
            );

            translationRepository.saveAll(translations);

        };
    }
}