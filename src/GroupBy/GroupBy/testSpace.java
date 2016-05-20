package GroupBy.GroupBy;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import GroupBy.GroupBy.bean.Photo;
import GroupBy.GroupBy.dao.PhotoJNDIDAO;

public class testSpace {

	public static void main(String[] args) throws NamingException {
		Photo ph = new Photo();
		List photos = new ArrayList();
		PhotoJNDIDAO controller = new PhotoJNDIDAO();
		photos = controller.findAll();
		for (int i = 0; i <= photos.size(); i++) {
			System.out.println(photos.get(i));
		}

	}

}
