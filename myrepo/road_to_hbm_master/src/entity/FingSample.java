package entity;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FingSample {

	public static void main(String[] args) throws HibernateException {
		Configuration config = new Configuration();

		// 設定の読み込み
		config = config.configure();

		// セッションファクトリーの生成
		SessionFactory sessionfactory = config.buildSessionFactory();

		// セッションオープン
		Session session = sessionfactory.openSession();

		// Empテーブルの全件検索
		List list = session.createCriteria(Emp.class).list();
		for (int i = 0; i < list.size(); i++) {
			Emp emp = (Emp) list.get(i);
			emp.writeLog();
		}
	}
}
