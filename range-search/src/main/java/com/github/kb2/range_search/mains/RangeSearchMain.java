package com.github.kb2.range_search.mains;

import java.util.ArrayList;
import java.util.List;

import com.github.kb2.range_search.dtos.RangeSearchTestDto;
import com.github.kb2.range_search.utils.RangeSearchUtil;

public class RangeSearchMain {

	/**
	 * 二分探索法を使った単位検索を行う
	 */
	public static void main(String[] args){

		// 範囲データ取得
		List<RangeSearchTestDto> rangeList = getRangeListOrderByFromVal();
		// 範囲データを元に、範囲検索Utilを作成
		RangeSearchUtil<RangeSearchTestDto> rangeSearchUtil = new RangeSearchUtil<RangeSearchTestDto>(rangeList);
		
		// 範囲検索実行
		{
			long searchVal = 100;
			// 範囲検索Utilを使って範囲検索実行
			RangeSearchTestDto result = rangeSearchUtil.getVal(searchVal);
			System.out.println("searchVal : " + searchVal + "resultfrom : " + result.fromVal + " resultTo : " + result.toVal);
		}
		{
			long searchVal = 201;
			RangeSearchTestDto result = rangeSearchUtil.getVal(searchVal);
			System.out.println("searchVal : " + searchVal + "resultfrom : " + result.fromVal + " resultTo : " + result.toVal);
		}
		{
			long searchVal = 1999;
			RangeSearchTestDto result = rangeSearchUtil.getVal(searchVal);
			System.out.println("searchVal : " + searchVal + "resultfrom : " + result.fromVal + " resultTo : " + result.toVal);
		}
		{
			long searchVal = 3500;
			RangeSearchTestDto result = rangeSearchUtil.getVal(searchVal);
			System.out.println("searchVal : " + searchVal + "resultfrom : " + result.fromVal + " resultTo : " + result.toVal);
		}
		{
			long searchVal = 2000;
			RangeSearchTestDto result = rangeSearchUtil.getVal(searchVal);
			if(result == null){
				System.out.println("searchVal : " + searchVal + " Not found.");
			}else{
				System.out.println("searchVal : " + searchVal + "resultfrom : " + result.fromVal + " resultTo : " + result.toVal);
			}
		}
		{
			long searchVal = 9999;
			RangeSearchTestDto result = rangeSearchUtil.getVal(searchVal);
			if(result == null){
				System.out.println("searchVal : " + searchVal + " Not found.");
			}else{
				System.out.println("searchVal : " + searchVal + "resultfrom : " + result.fromVal + " resultTo : " + result.toVal);
			}
		}
		
	}
	
	/**
	 * 範囲データをFrom値の値でソートして取得する
	 * @return
	 */
	private static List<RangeSearchTestDto> getRangeListOrderByFromVal(){
		// from値の昇順でソートされた、互いに重ならない範囲データ一覧
		List<RangeSearchTestDto> rangeList = new ArrayList<RangeSearchTestDto>();
		rangeList.add(new RangeSearchTestDto(100, 199));
		rangeList.add(new RangeSearchTestDto(200, 299));
		rangeList.add(new RangeSearchTestDto(300, 499));
		rangeList.add(new RangeSearchTestDto(400, 599));
		rangeList.add(new RangeSearchTestDto(1000, 1999));
		rangeList.add(new RangeSearchTestDto(3000, 3990));
		return rangeList;
	}
}
