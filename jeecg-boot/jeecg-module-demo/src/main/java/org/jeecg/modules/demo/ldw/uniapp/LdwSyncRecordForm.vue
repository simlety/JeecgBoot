<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">ldw_sync_record</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">目标表名（冗余存储便于快速定位）：</text></view>
                  <input  placeholder="请输入目标表名（冗余存储便于快速定位）" v-model="model.tableName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">实际执行SQL：</text></view>
                  <input  placeholder="请输入实际执行SQL" v-model="model.executedSql"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档：</text></view>
                  <input type="number" placeholder="请输入0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档" v-model="model.status"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">异常概要信息：</text></view>
                  <input  placeholder="请输入异常概要信息" v-model="model.errorMessage"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">完整异常堆栈（建议JSON格式存储）：</text></view>
                  <input  placeholder="请输入完整异常堆栈（建议JSON格式存储）" v-model="model.errorStack"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">重试次数：</text></view>
                  <input type="number" placeholder="请输入重试次数" v-model="model.retryCount"/>
                </view>
              </view>
              <my-date label="最后一次重试时间：" v-model="model.lastRetryTime" placeholder="请输入最后一次重试时间"></my-date>
				<view class="padding">
					<button class="cu-btn block bg-blue margin-tb-sm lg" @click="onSubmit">
						<text v-if="loading" class="cuIcon-loading2 cuIconfont-spin"></text>提交
					</button>
				</view>
			</form>
		</view>
    </view>
</template>

<script>
    import myDate from '@/components/my-componets/my-date.vue'

    export default {
        name: "LdwSyncRecordForm",
        components:{ myDate },
        props:{
          formData:{
              type:Object,
              default:()=>{},
              required:false
          }
        },
        data(){
            return {
				CustomBar: this.CustomBar,
				NavBarColor: this.NavBarColor,
				loading:false,
                model: {},
                backRouteName:'index',
                url: {
                  queryById: "/ldw/ldwSyncRecord/queryById",
                  add: "/ldw/ldwSyncRecord/add",
                  edit: "/ldw/ldwSyncRecord/edit",
                },
            }
        },
        created(){
             this.initFormData();
        },
        methods:{
           initFormData(){
               if(this.formData){
                    let dataId = this.formData.dataId;
                    this.$http.get(this.url.queryById,{params:{id:dataId}}).then((res)=>{
                        if(res.data.success){
                            console.log("表单数据",res);
                            this.model = res.data.result;
                        }
                    })
                }
            },
            onSubmit() {
                let myForm = {...this.model};
                this.loading = true;
                let url = myForm.id?this.url.edit:this.url.add;
				this.$http.post(url,myForm).then(res=>{
				   console.log("res",res)
				   this.loading = false
				   this.$Router.push({name:this.backRouteName})
				}).catch(()=>{
					this.loading = false
				});
            }
        }
    }
</script>
