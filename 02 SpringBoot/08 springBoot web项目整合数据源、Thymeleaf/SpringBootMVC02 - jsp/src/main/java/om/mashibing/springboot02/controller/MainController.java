package om.mashibing.springboot02.controller;

import java.io.IOException;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/city")
public class MainController {

	@Autowired
	private DefaultFastFileStorageClient fc;
//
//	@RequestMapping("/page")
//	public String page() throws IOException {
////		ModelAndView modelAndView  = new ModelAndView();
////		modelAndView.setViewName("upload");
//		return "upload" ;
//	}

	@PostMapping("/upload")
	@ResponseBody
	public void upload(MultipartFile file) throws IOException {

		fc.uploadFile(file.getInputStream(),file.getSize(),file.getOriginalFilename(),null);

	}

//	@Autowired
//	CityService citySrv;
//
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list() {

		return "list" ;
	}
//
//	@RequestMapping("list/{id}")
//	public String getOne(@PathVariable("id") Integer id,Model model) {
//
//
//		City city = citySrv.findOne(id);
//
//		model.addAttribute("city", city);
//		return "list1";
//	}
	
}
