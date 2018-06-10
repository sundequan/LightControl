package repo.sundq.light.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import repo.sundq.light.json.HttpJsonResult;
import repo.sundq.light.persistent.jpa.Device;
import repo.sundq.light.persistent.jpa.DeviceRepository;
import repo.sundq.light.pojo.HttpMsg;

/**
 * 
 * @author ksun
 * @date 2018年6月3日
 */

@RestController
@RequestMapping("/msg")
public class HttpSendController {
	private Logger logger = LoggerFactory.getLogger(HttpSendController.class);
	
	@Autowired
	private DeviceRepository deviceRepo;
	
	@RequestMapping(value="/send_test", produces="application/json;charset=utf-8")
	public HttpJsonResult send(String msg) {
		logger.info("get http send:" + msg);
		return HttpJsonResult.build(200, "ok", null);
	}
	
	@RequestMapping(value="/add_device", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public HttpJsonResult add_device(Device device) {
		deviceRepo.saveAndFlush(device);
		return HttpJsonResult.build(200, "ok", device);
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	public HttpJsonResult send(@RequestBody HttpMsg httpMsg, HttpServletRequest request) {
		return HttpJsonResult.build(200, "OK", httpMsg);
	}
}
