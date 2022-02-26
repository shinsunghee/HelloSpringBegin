package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforEach(){
        memoryMemberRepository =new MemoryMemberRepository();

        memberService = new MemberService(memoryMemberRepository);
    }
    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member mem1 = new Member();
        mem1.setName("String");

        //when
        Long saveid = memberService.join(mem1);
        //then

        Member member = memberService.findOne(saveid).get();
        assertThat(mem1.getName()).isEqualTo(member.getName());

    }

    @Test
    public void 중복회원(){
        //given
        Member member1 = new Member();
        member1.setName("String");


        Member member2 = new Member();
        member2.setName("String");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class , ()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*try{
            memberService.join(member2);
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.12");
        }*/


        //then



    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}