import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '目标表名（冗余存储便于快速定位）',
    align:"center",
    dataIndex: 'tableName'
   },
   {
    title: '实际执行SQL',
    align:"center",
    dataIndex: 'executedSql'
   },
   {
    title: '0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '异常概要信息',
    align:"center",
    dataIndex: 'errorMessage'
   },
   {
    title: '完整异常堆栈（建议JSON格式存储）',
    align:"center",
    dataIndex: 'errorStack'
   },
   {
    title: '重试次数',
    align:"center",
    dataIndex: 'retryCount'
   },
   {
    title: '最后一次重试时间',
    align:"center",
    dataIndex: 'lastRetryTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '目标表名（冗余存储便于快速定位）',
    field: 'tableName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入目标表名（冗余存储便于快速定位）!'},
          ];
     },
  },
  {
    label: '实际执行SQL',
    field: 'executedSql',
    component: 'InputTextArea',
  },
  {
    label: '0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档',
    field: 'status',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档!'},
          ];
     },
  },
  {
    label: '异常概要信息',
    field: 'errorMessage',
    component: 'InputTextArea',
  },
  {
    label: '完整异常堆栈（建议JSON格式存储）',
    field: 'errorStack',
    component: 'InputTextArea',
  },
  {
    label: '重试次数',
    field: 'retryCount',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入重试次数!'},
          ];
     },
  },
  {
    label: '最后一次重试时间',
    field: 'lastRetryTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
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
  tableName: {title: '目标表名（冗余存储便于快速定位）',order: 0,view: 'text', type: 'string',},
  executedSql: {title: '实际执行SQL',order: 1,view: 'textarea', type: 'string',},
  status: {title: '0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档',order: 2,view: 'number', type: 'number',},
  errorMessage: {title: '异常概要信息',order: 3,view: 'textarea', type: 'string',},
  errorStack: {title: '完整异常堆栈（建议JSON格式存储）',order: 4,view: 'textarea', type: 'string',},
  retryCount: {title: '重试次数',order: 5,view: 'number', type: 'number',},
  lastRetryTime: {title: '最后一次重试时间',order: 6,view: 'datetime', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}