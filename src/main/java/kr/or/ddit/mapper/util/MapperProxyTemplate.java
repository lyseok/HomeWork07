package kr.or.ddit.mapper.util;

import java.util.function.Function;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;

public class MapperProxyTemplate<T> {
	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	private final Class<T> mapperType;
	
	public MapperProxyTemplate(Class<T> mapperType) {
		super();
		this.mapperType = mapperType;
	}


	public <R> R execute(Function<T, R> lambda) {
//		1. session 생성
//		2. Mapper proxy생성
//		3. 매번 다른 쿼리가 실행되어야함
//		4. 세션 종료
		try(
			SqlSession session = factory.openSession(true);
		){
			T proxy = session.getMapper(mapperType);
			return lambda.apply(proxy);		
		}
	}
	
}
