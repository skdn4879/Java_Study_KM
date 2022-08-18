package kr.co.practice;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// context파일의 위치를 지정하는 Annotation, **은 해당 폴더와 하위폴더 모두 검색하겠다는 뜻, -context.xml로 끝나는 모든 파일
// 우리는 context파일은 -context.xml로 끝나기로 약속함
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class DBTest {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		
		// 단정문
		assertNotNull(sqlSession);	//null이 아니길 희망한다. -> null이 아니면 성공, null이면 Failures
	}

}
