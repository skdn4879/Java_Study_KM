package kr.co.practice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//context파일의 위치를 지정하는 Annotation, **은 해당 폴더와 하위폴더 모두 검색하겠다는 뜻, -context.xml로 끝나는 모든 파일
//우리는 context파일은 -context.xml로 끝나기로 약속함
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public abstract class MyAbstractTest {

	// 어노테이션을 일일이 붙이기 귀찮으니 이 추상메소드에 어노테이션을 붙이고 다른 애들이 상속받는 형태로 하면 간편하다.

}
