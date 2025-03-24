<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">ldw_product_inventory</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品SKU（平台标准识别码）：</text></view>
                  <input  placeholder="请输入产品SKU（平台标准识别码）" v-model="model.sku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">客户自定义SKU（最大长度255）：</text></view>
                  <input  placeholder="请输入客户自定义SKU（最大长度255）" v-model="model.clientSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">仓库名称（包含仓库编码信息）：</text></view>
                  <input  placeholder="请输入仓库名称（包含仓库编码信息）" v-model="model.warehouseName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">可用库存数量：</text></view>
                  <input type="number" placeholder="请输入可用库存数量" v-model="model.goodNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">锁定库存数量：</text></view>
                  <input type="number" placeholder="请输入锁定库存数量" v-model="model.lockNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">亚马逊标准识别号（ASIN）：</text></view>
                  <input  placeholder="请输入亚马逊标准识别号（ASIN）" v-model="model.asin"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">销售渠道SKU：</text></view>
                  <input  placeholder="请输入销售渠道SKU" v-model="model.sellerSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">商品活跃天数：</text></view>
                  <input type="number" placeholder="请输入商品活跃天数" v-model="model.activeDays"/>
                </view>
              </view>
              <my-date label="最近活跃时间：" v-model="model.activeTime" placeholder="请输入最近活跃时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">仓库库位编码：</text></view>
                  <input  placeholder="请输入仓库库位编码" v-model="model.positionCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">处理中的库存数量：</text></view>
                  <input type="number" placeholder="请输入处理中的库存数量" v-model="model.processingNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">历史累计入库数量：</text></view>
                  <input type="number" placeholder="请输入历史累计入库数量" v-model="model.historyInNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">历史累计出库数量：</text></view>
                  <input type="number" placeholder="请输入历史累计出库数量" v-model="model.historyOutNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最近7天出库数量：</text></view>
                  <input type="number" placeholder="请输入最近7天出库数量" v-model="model.outputNum"/>
                </view>
              </view>
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
        name: "LdwProductInventoryForm",
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
                  queryById: "/ldw/ldwProductInventory/queryById",
                  add: "/ldw/ldwProductInventory/add",
                  edit: "/ldw/ldwProductInventory/edit",
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
