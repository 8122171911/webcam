package webcam.app;

import java.io.IOException;
import java.nio.file.Files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="videoreceiver", urlPatterns = "/videoreceiver")
public class VideoReceiverServlet extends HttpServlet{
	private static final long serialVersionUID = -1268211588216696691L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		byte[] buffer=new byte[512];
		while(req.getInputStream().read(buffer, 0, 512)>=0) {			
			try {
				Files.
				Registry.getInstance().getBqueue().add(buffer);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				Registry.getInstance().getBqueue().poll();
				Registry.getInstance().getBqueue().add(buffer);
			}
		}
	}	
}
