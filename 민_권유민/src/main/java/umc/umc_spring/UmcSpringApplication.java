package umc.umc_spring;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.umc_spring.domain.Member;
import umc.umc_spring.service.MemberQueryService;
import umc.umc_spring.service.MissionQueryService;
import umc.umc_spring.service.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class UmcSpringApplication{

	public static void main(String[] args) {
		SpringApplication.run(UmcSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		System.out.println("run");
		return args -> {
			try {
				System.out.println("=== CommandLineRunner 시작 ===");

				//가게 조회
				StoreQueryService storeService = context.getBean(StoreQueryService.class);

				String name = "요아정";
				Float score = 4.0f;

				System.out.println("Executing findStoresByNameAndScore with parameters:");
				System.out.println("Name: " + name);
				System.out.println("Score: " + score);

				storeService.findStoresByNameAndScore(name, score)
						.forEach(System.out::println);

				//미션 조회
				MissionQueryService missionService = context.getBean(MissionQueryService.class);

				Long memberId = 1L;
				Long cursor = Long.MAX_VALUE; // 가장 최근부터 가져오기 위함

				System.out.println("=== 진행 중인 미션 조회 ===");
				missionService.getInProgressMissions(memberId, cursor)
						.forEach(System.out::println);

				System.out.println("=== 완료된 미션 조회 ===");
				missionService.getCompletedMissions(memberId, cursor)
						.forEach(System.out::println);

				//멤버 조회 (마이페이지)
				MemberQueryService memberQueryService = context.getBean(MemberQueryService.class);
				//Long memberId = 1L;

				System.out.println("Executing getMemberById with parameter:");
				System.out.println("Member ID: " + memberId);
				try {
					Member member = memberQueryService.getMemberById(memberId);
					System.out.println("=== 회원 정보 ===");
					System.out.println("이름: " + member.getName());
					System.out.println("이메일: " + member.getEmail());
					System.out.println("전화번호: " + member.getPhoneNumber());
					System.out.println("포인트: " + member.getPoint());
				} catch (EntityNotFoundException e) {
					System.out.println("회원을 찾을 수 없습니다: " + e.getMessage());
				}

			} catch (Exception e) {
				System.out.println("예외 발생!");
				e.printStackTrace();  // 여기서 무슨 문제인지 확인 가능
			}
		};
	}
}