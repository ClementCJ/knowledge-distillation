package com.antbrians.rufodao.extractor;

import com.antbrains.sc.extractor.Extractor;
import com.antbrains.sc.extractor.NullExtractor;
import com.antbrains.sc.extractor.UrlPatternExtractor;
import com.antbrains.sc.extractor.UrlPatternExtractor4Hbase;

public class RufodaoExtractor extends UrlPatternExtractor {
	private Extractor[] extractors = new Extractor[] {
			new Level0Extractor(),
			new Level1Extractor(),
	};

	@Override
	public Extractor getExtractor(String url, String redirectedUrl, int depth) {
		if(depth==0){
			return extractors[0];
		}else if(depth==1){
			return extractors[1];
		}
		return null;
	}

	public static void main(String[] args) {
		String[] urls = new String[] { "http://rufodao.qq.com/l/foxue/foxuexinwen/foxuezixun/list2015116102442.htm", };
		String[] redirectedUrls = new String[urls.length];

		int[] depths = new int[] { 0, };
		RufodaoExtractor bme = new RufodaoExtractor();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i] + "\t" + redirectedUrls[i] + "\t" + depths[i]);
			Extractor ext = bme.getExtractor(urls[i], redirectedUrls[i], depths[i]);
			if (ext == null) {
				System.out.println("\tnull");
			} else {
				System.out.println("\t" + ext.getClass().getSimpleName());
			}
		}
	}
}
