package acb.blockchain.acbblockchainnode;

import org.junit.Test;

import acb.blockchain.util.HTTPUtils;

public class HttpTests {

	@Test
	public void contextLoads() {
		// demo:代理访问
		String url = "http://127.0.0.1:8080";
		String para = "";

		String sr = HTTPUtils.sendPost(url + "/Block", para, false);
		System.out.println(sr);
		sr = HTTPUtils.sendGet(url + "/Block/1", para);
		System.out.println(sr);
		sr = HTTPUtils.sendGet(url + "/BlockChain", para);
		System.out.println(sr);
	}
	
	@Test
	public void test() {
		// demo:代理访问
		String url = "https://opentest.hopebank.com:15520/DidiWay/loanApply";
		String para = "{\"appId\":\"3015\",\"bizContent\":\"{\\\"bankCardNo\\\":\\\"6226624817905924\\\",\\\"idNo\\\":\\\"62052219840416769X\\\",\\\"issueTime\\\":\\\"2018-03-15 12:17:47\\\",\\\"loanAmount\\\":3E+7,\\\"loanExtends\\\":\\\"lD1XT7ORxUtbPNue02cp13aLxC0MOQUNa5CS8%2FlFba6spGxxcWy85fAiIHVXfHn32Onemsi9kIYbNvVqKg1HfpB9JTG0EPgYDg%2B7A8SJWz9ajBrmQMiwRE27mc%2F0L18y\\\",\\\"loanOrderId\\\":\\\"DD0002301520180315121700931362\\\",\\\"loanRating\\\":3E+8,\\\"message\\\":\\\"账户不存在\\\",\\\"mobile\\\":\\\"18693571036\\\",\\\"name\\\":\\\"张三\\\",\\\"penaltyInterestRate\\\":4.5E+8,\\\"repayPlanList\\\":[],\\\"repayType\\\":1,\\\"status\\\":\\\"2\\\",\\\"totalInstallment\\\":3,\\\"tranDate\\\":\\\"2018-03-15\\\",\\\"tranSerNum\\\":\\\"20180315121747062348519079986266\\\"}\",\"sign\":\"UUc1atKQriMz5dUOwHWH1hv0g66N6WPtnOgBdf5Ei1blfcc5R%2BSbBCADzzciy6bDyXWvDu6yOjCq%0AO8tU17DTaJSyZnuAsLRPCKYKbn67aesUf1d96J9dqwlcaEigDuuMxq6If4zKPB%2BCRv%2FprVJVHtLv%0AmwgIgfZYq%2BD7jprdviE%3D%0A\",\"signType\":\"RSA\"}";

		String sr = HTTPUtils.sendPost(url, para, false);
		System.out.println(sr);
	}
}
