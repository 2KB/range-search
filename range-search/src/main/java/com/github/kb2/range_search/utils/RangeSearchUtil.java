package com.github.kb2.range_search.utils;

import java.util.List;

/**
 * 二分探索方を使って範囲検索をするUtilクラス
 * @param <T> RangeSeachInterfaceを継承したクラスをジェネリクスとする
 */
public class RangeSearchUtil<T extends RangeSearchInterface> {

	/**
	 * RangeSearchInterfaceを継承した範囲データを保持する
	 */
	private List<T> rangeSearchList;
	
	/**
	 * 範囲検索データを設定するコンストラクタ
	 * @param valueList
	 */
	public RangeSearchUtil(List<T> valueList){
		rangeSearchList = valueList;
	}
	
	/**
	 * 二分探索法を使って範囲検索してマッチした値を取得する。
	 * 
	 * 参考:http://blog.akagi.jp/archives/179.html
	 * 参考:https://www.grapecity.com/tools/support/powernews/column/clang/054/page03.htm
	 */
	public T getVal(long searchVal) {
	
		// 検索中の最小Index
		int lowid  = 0;
		
		// 検索中の最大Index
		int highid = rangeSearchList.size() - 1;
		
		// 検索中の最小indexの値が、最大indexの値以下である間は繰り返す
		while(lowid <= highid){

			// 中間Index
			int midid = (lowid + highid) / 2;
			
			// 中間の値を取得
			T midResult = rangeSearchList.get(midid);
			long midFromVal = midResult.getFromValue();
			long midToVal = midResult.getToValue();
			
			if(midFromVal <= searchVal && searchVal <= midToVal){
				// 取得した中間値が検索値内だったら、取得した値を返す
				return midResult;
			}else if(midToVal < searchVal){
				// 取得した中間値の上限値が検索値より小さかった場合は、最小Indexを今回の中間Indexより大きくする
				lowid = midid + 1;
			}else{
				// 取得した中間値の上限値が検索値より大きかった場合は、最大Indexを今回の中間Indexより小さくする
				highid = midid - 1;
			}
		}

		// 検索範囲内には含まれなかった場合
		return null;
	}
}
