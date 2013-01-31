package test;
import static org.junit.Assert.*;

import info.nohoho.util.*;

import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;



public class TestExec extends TestCase{
	
	private Map<String,Object> map;
	
	protected void setUp() {
		map = new DupableLinkedHashMap<String, Object>();
		map.put("hoge", "hoge");
		map.put("huga", "huga");
		map.put("moge", "moge");
	}
	
	@Test
	public void test1() {
		System.out.println(getString(map.entrySet()));
		assertEquals(3, map.size());
	}

	@Test
	public void test2() {
		map.put("hoge", "moge");
		System.out.print(getString(map.entrySet()));
		assertEquals(3, map.size());
	}
	
	
	private String getString (Set<Map.Entry<String, Object>> entry) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> e : entry) {
			sb.append("<"+e.getKey()+", "+e.getValue().toString()+">\n");
		}
		return sb.toString();
	}
	
}
