import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '配置键（唯一标识）',
    align:"center",
    dataIndex: 'configKey'
   },
   {
    title: '配置值',
    align:"center",
    dataIndex: 'configValue'
   },
   {
    title: '配置描述',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '状态（0-禁用 1-启用）',
    align:"center",
    dataIndex: 'status'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "配置键（唯一标识）",
      field: 'configKey',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "配置描述",
      field: 'description',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "状态（0-禁用 1-启用）",
      field: 'status',
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '配置键（唯一标识）',
    field: 'configKey',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入配置键（唯一标识）!'},
          ];
     },
  },
  {
    label: '配置值',
    field: 'configValue',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入配置值!'},
          ];
     },
  },
  {
    label: '配置描述',
    field: 'description',
    component: 'Input',
  },
  {
    label: '状态（0-禁用 1-启用）',
    field: 'status',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态（0-禁用 1-启用）!'},
          ];
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  configKey: {title: '配置键（唯一标识）',order: 0,view: 'text', type: 'string',},
  configValue: {title: '配置值',order: 1,view: 'textarea', type: 'string',},
  description: {title: '配置描述',order: 2,view: 'text', type: 'string',},
  status: {title: '状态（0-禁用 1-启用）',order: 3,view: 'number', type: 'number',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}