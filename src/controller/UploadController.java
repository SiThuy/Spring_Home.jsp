package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("standing")
public class UploadController {
	private static String upload(String path, MultipartFile part) throws IOException {
		String fileName = part.getOriginalFilename().replaceAll("\\s", "_");
		try (InputStream is = part.getInputStream()) {
			try (OutputStream os = new FileOutputStream(new File(path + fileName))) {
				int len = 0;
				byte[] bytes = new byte[1024];
				while ((len = is.read(bytes, 0, 1024)) > 0) {
					os.write(bytes, 0, len);
				}
			}
		}
		return fileName;
	}

	@RequestMapping("simple.html")
	public String simple() {
		return "standing";
	}

	@RequestMapping(value = "simple.html", method = RequestMethod.POST)
	public String simple(Model model, @RequestParam("f") MultipartFile part, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/upload/");
		try {
			String name = upload(path, part);
			model.addAttribute("name", name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "standing";
	}
}
