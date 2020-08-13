package com.ctgu.salary.controller;

import com.ctgu.salary.dto.DepartmentName;
import com.ctgu.salary.dto.PositionDto;
import com.ctgu.salary.dto.ResultBody;
import com.ctgu.salary.dto.StaffDto;
import com.ctgu.salary.po.Staff;
import com.ctgu.salary.service.DepartmentService;
import com.ctgu.salary.service.PositionService;
import com.ctgu.salary.service.StaffService;
import com.ctgu.salary.utils.OssUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description TODO
 * @Author wh_lan
 * @create 2020-08-07 11:06
 * @ClassName StaffController
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;
    private final DepartmentService departmentService;
    private final PositionService positionService;

    @Autowired
    public StaffController(StaffService staffService , DepartmentService departmentService,
                           PositionService positionService) {
        this.staffService = staffService;
        this.departmentService = departmentService;
        this.positionService = positionService;
    }


    /**
     * @Author wh
     * @Description 全部员工
     * @Date 2020/8/8 12:46
     * @Param [startPage, pageSize]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/list" , method = RequestMethod.GET )
    public ResultBody allStaffs(@RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        ResultBody resultBody = new ResultBody();
        PageHelper.startPage(startPage, pageSize);
        List<StaffDto> staffList = staffService.findAllStaff();
        PageInfo<StaffDto> staffs = new PageInfo<>(staffList);
        resultBody.setResult(staffs);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 增加员工时全部部门
     * @Date 2020/8/8 12:52
     * @Param []
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/depart-list" , method = RequestMethod.GET )
    public ResultBody allDepartName(){
        ResultBody resultBody = new ResultBody();
        List<DepartmentName> departmentNames = departmentService.findAllDepartmentName();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(departmentNames);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 一个部门下所有的岗位,增加员工的时候选择岗位
     * @Date 2020/8/8 17:13
     * @Param [departId]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/position-list" , method = RequestMethod.GET )
    public ResultBody departAllPosition(@RequestParam(value = "departId", defaultValue = "1")Integer departId){
        ResultBody resultBody = new ResultBody();
        List<PositionDto> positionDtos = positionService.findPositionByDepartId(departId);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(positionDtos);
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 员工详情
     * @Date 2020/8/7 12:01
     * @Param [staffId]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @RequestMapping(value = "/detail" , method = RequestMethod.GET )
    public ResultBody staffDetail(@RequestParam("staffId")Integer staffId){
        ResultBody resultBody = new ResultBody();
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        StaffDto staffDto = staffService.findStaffDetail(staffId);
        resultBody.setResult(staffDto);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 换头像
     * @Date 2020/8/8 19:27
     * @Param [multipartFile]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @PostMapping("/avatar")
    public ResultBody updateStaffAvatar(@RequestParam(value = "avatar",required = false) MultipartFile avatar){
        ResultBody resultBody = new ResultBody();
        if( avatar != null ){
            String avatarName = avatar.getName();
            String extension = OssUtil.getFileExtension(avatar);
            //判断是否是图片
            if( extension.equalsIgnoreCase(".jpg") || extension.equalsIgnoreCase(".png")
                    || extension.equalsIgnoreCase(".jpeg")){
                String avatarUrl = OssUtil.upLoadFile(avatarName,avatar);
                if( avatarUrl.equals("error") ) {
                    resultBody.setMsg("上传失败");
                    resultBody.setStatusCode("500");
                }
                else {
//                    staffService.updateStaffAvatar(avatarUrl);
                    resultBody.setResult(avatarUrl);
                    resultBody.setMsg("success");
                    resultBody.setStatusCode("200");
                }
            }
            else{
                resultBody.setMsg("请上传图片");
                resultBody.setStatusCode("500");
            }
        }
        else{
            resultBody.setMsg("接收文件失败");
            resultBody.setStatusCode("500");
        }
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 增加员工
     * @Date 2020/8/8 21:08
     * @Param [staff]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @PostMapping("/add")
    public ResultBody addOneStaff(@RequestBody(required = false) Staff staff){
        ResultBody resultBody = new ResultBody();
        if( staffService.findOneStaffByIdCard(staff.getIdCard()) == null ){
            staffService.addStaff(staff);
            resultBody.setMsg("success");
            resultBody.setStatusCode("200");
        }
        else{
            resultBody.setMsg("已经存在");
            resultBody.setStatusCode("200");
        }
        resultBody.setResult(staff);
        return resultBody;

    }

    /**
     * @Author wh
     * @Description 修改员工信息
     * @Date 2020/8/8 20:52
     * @Param [staff]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @PostMapping("/update")
    public ResultBody updateOneStaff(@RequestBody(required = false) Staff staff){
        ResultBody resultBody = new ResultBody();
        staffService.updateStaff(staff);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        StaffDto updateStaff = staffService.findStaffDetail(staff.getStaffId());
        resultBody.setResult(updateStaff);
        return resultBody;
    }

    /**
     * @Author wh
     * @Description 删除员工
     * @Date 2020/8/8 20:04
     * @Param [staffId]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @GetMapping("/del")
    public ResultBody delStaff(@RequestParam("staffId")Integer staffId){
        ResultBody resultBody = new ResultBody();
        staffService.delStaffById(staffId);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        return resultBody;
    }


    /**
     * @Author wh
     * @Description 通过身份证查找
     * @Date 2020/8/11 17:09
     * @Param [idCard]
     * @return com.ctgu.salary.dto.ResultBody
     **/
    @GetMapping("/find-idCard")
    public ResultBody findByIdCard(@RequestParam("idCard")String idCard,
                                   @RequestParam(value = "startPage", required = false, defaultValue = "1") Integer startPage,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){

        ResultBody resultBody = new ResultBody();
        List<StaffDto> staffs = staffService.findStaffByIdCard(idCard);
        PageHelper.startPage(startPage, pageSize);
        PageInfo<StaffDto> staffDtoPageInfo = new PageInfo<>(staffs);
        resultBody.setMsg("success");
        resultBody.setStatusCode("200");
        resultBody.setResult(staffDtoPageInfo);
        return resultBody;
    }


}










