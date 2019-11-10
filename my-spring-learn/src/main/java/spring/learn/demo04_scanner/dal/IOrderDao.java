package spring.learn.demo04_scanner.dal;

import spring.learn.demo04_scanner.anno.MyMapper;

import java.util.List;

@MyMapper
public interface IOrderDao {

	public List<Integer> selectList();


}
