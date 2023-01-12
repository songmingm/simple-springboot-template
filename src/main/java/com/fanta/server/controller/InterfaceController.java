package com.fanta.server.controller;

import com.fanta.server.common.ResponseData;
import com.fanta.server.model.dto.interfaceInfo.InterfaceInsertParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口web层
 *
 * @author mmsong
 */
@RestController
@RequestMapping("interface")
public class InterfaceController extends BaseController {

    private ResponseData insert(InterfaceInsertParam param) {

    }
}
