<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">ldw_product_info</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">系统SKU|产品编码：</text></view>
                  <input  placeholder="请输入系统SKU|产品编码" v-model="model.sku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">自定义SKU：</text></view>
                  <input  placeholder="请输入自定义SKU" v-model="model.clientSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品英文名：</text></view>
                  <input  placeholder="请输入产品英文名" v-model="model.productName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品特点：</text></view>
                  <input  placeholder="请输入产品特点" v-model="model.featureList"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">包装清单：</text></view>
                  <input  placeholder="请输入包装清单" v-model="model.packingList"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品颜色属性：</text></view>
                  <input  placeholder="请输入产品颜色属性" v-model="model.productColor"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品尺码属性：</text></view>
                  <input  placeholder="请输入产品尺码属性" v-model="model.productSize"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品净重(g)：</text></view>
                  <input type="number" placeholder="请输入产品净重(g)" v-model="model.netWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品毛重(g)：</text></view>
                  <input type="number" placeholder="请输入产品毛重(g)" v-model="model.grossWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">销售价：</text></view>
                  <input type="number" placeholder="请输入销售价" v-model="model.salePrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">库存数量：</text></view>
                  <input type="number" placeholder="请输入库存数量" v-model="model.goodNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">B2C页面Title：</text></view>
                  <input  placeholder="请输入B2C页面Title" v-model="model.pageTitle"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">B2C页面关键词描述：</text></view>
                  <input  placeholder="请输入B2C页面关键词描述" v-model="model.mateDescription"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">B2C页面关键词：</text></view>
                  <input  placeholder="请输入B2C页面关键词" v-model="model.mateKeyword"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">搜索关键词：</text></view>
                  <input  placeholder="请输入搜索关键词" v-model="model.searchKeyword"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品报关名：</text></view>
                  <input  placeholder="请输入产品报关名" v-model="model.declarationName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品报关中文名：</text></view>
                  <input  placeholder="请输入产品报关中文名" v-model="model.declarationNameCn"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品报关材质：</text></view>
                  <input  placeholder="请输入产品报关材质" v-model="model.declarationMaterial"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品报关价：</text></view>
                  <input type="number" placeholder="请输入产品报关价" v-model="model.declarationPriceRate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品上架状态：</text></view>
                  <input  placeholder="请输入产品上架状态" v-model="model.onlineStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最新供货价：</text></view>
                  <input type="number" placeholder="请输入最新供货价" v-model="model.lastSupplierPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品最新采购价：</text></view>
                  <input type="number" placeholder="请输入产品最新采购价" v-model="model.lastBuyPrice"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品单件采购运费：</text></view>
                  <input type="number" placeholder="请输入产品单件采购运费" v-model="model.unitShipFee"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品长(cm)：</text></view>
                  <input type="number" placeholder="请输入产品长(cm)" v-model="model.length"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品宽(cm)：</text></view>
                  <input type="number" placeholder="请输入产品宽(cm)" v-model="model.width"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品高(cm)：</text></view>
                  <input type="number" placeholder="请输入产品高(cm)" v-model="model.height"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">包装长(cm)：</text></view>
                  <input type="number" placeholder="请输入包装长(cm)" v-model="model.packLength"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">包装宽(cm)：</text></view>
                  <input type="number" placeholder="请输入包装宽(cm)" v-model="model.packWidth"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">包装高(cm)：</text></view>
                  <input type="number" placeholder="请输入包装高(cm)" v-model="model.packHeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">侵权风险：</text></view>
                  <input  placeholder="请输入侵权风险" v-model="model.productProperty"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">物流属性：</text></view>
                  <input  placeholder="请输入物流属性" v-model="model.withBattery"/>
                </view>
              </view>
              <my-date label="产品图片更新时间：" v-model="model.updateImageDateTime" placeholder="请输入产品图片更新时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">母体ID：</text></view>
                  <input  placeholder="请输入母体ID" v-model="model.productGroupSku"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">一级分类ID：</text></view>
                  <input type="number" placeholder="请输入一级分类ID" v-model="model.classId1"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">二级分类ID：</text></view>
                  <input type="number" placeholder="请输入二级分类ID" v-model="model.classId2"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最后一级分类ID：</text></view>
                  <input type="number" placeholder="请输入最后一级分类ID" v-model="model.lastClassId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">完整英文分类：</text></view>
                  <input  placeholder="请输入完整英文分类" v-model="model.fullClassNameEn"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品中文名：</text></view>
                  <input  placeholder="请输入产品中文名" v-model="model.productNameCn"/>
                </view>
              </view>
              <my-date label="上架时间：" v-model="model.onlineTime" placeholder="请输入上架时间"></my-date>
              <my-date label="添加时间：" v-model="model.addTime" placeholder="请输入添加时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开发人员：</text></view>
                  <input  placeholder="请输入开发人员" v-model="model.developAdminName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">采购人员：</text></view>
                  <input  placeholder="请输入采购人员" v-model="model.buyerName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">供应商：</text></view>
                  <input  placeholder="请输入供应商" v-model="model.supplierName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">供应商ID：</text></view>
                  <input type="number" placeholder="请输入供应商ID" v-model="model.supplierId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">封面缩略图URL：</text></view>
                  <input  placeholder="请输入封面缩略图URL" v-model="model.smallImageUrl"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品来源：</text></view>
                  <input  placeholder="请输入产品来源" v-model="model.comeSource"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开发类型：</text></view>
                  <input  placeholder="请输入开发类型" v-model="model.developType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">图片来源：</text></view>
                  <input  placeholder="请输入图片来源" v-model="model.pictureSource"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">外箱长(cm)：</text></view>
                  <input type="number" placeholder="请输入外箱长(cm)" v-model="model.cartonLength"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">外箱宽(cm)：</text></view>
                  <input type="number" placeholder="请输入外箱宽(cm)" v-model="model.cartonWidth"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">外箱高(cm)：</text></view>
                  <input type="number" placeholder="请输入外箱高(cm)" v-model="model.cartonHeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">每箱数量：</text></view>
                  <input type="number" placeholder="请输入每箱数量" v-model="model.cartonPcsNum"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">整箱毛重(kg)：</text></view>
                  <input type="number" placeholder="请输入整箱毛重(kg)" v-model="model.cartonGrossWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">整箱净重(kg)：</text></view>
                  <input type="number" placeholder="请输入整箱净重(kg)" v-model="model.cartonNetWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品状态：</text></view>
                  <input  placeholder="请输入产品状态" v-model="model.productState"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">采购链接：</text></view>
                  <input  placeholder="请输入采购链接" v-model="model.webProductUrl"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开发审核状态：</text></view>
                  <input  placeholder="请输入开发审核状态" v-model="model.developStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">编辑审核状态：</text></view>
                  <input  placeholder="请输入编辑审核状态" v-model="model.editStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">图片审核状态：</text></view>
                  <input  placeholder="请输入图片审核状态" v-model="model.imageStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">终审状态：</text></view>
                  <input  placeholder="请输入终审状态" v-model="model.checkStatus"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">一级类目中文：</text></view>
                  <input  placeholder="请输入一级类目中文" v-model="model.classNameCn1"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">日均销量：</text></view>
                  <input type="number" placeholder="请输入日均销量" v-model="model.avgDailySales"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品活跃度：</text></view>
                  <input  placeholder="请输入产品活跃度" v-model="model.productVitalityType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">新品类型：</text></view>
                  <input  placeholder="请输入新品类型" v-model="model.productNewType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品用途：</text></view>
                  <input  placeholder="请输入产品用途" v-model="model.declarationPurpose"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">图片处理人员：</text></view>
                  <input  placeholder="请输入图片处理人员" v-model="model.imageAdminName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品编辑人员：</text></view>
                  <input  placeholder="请输入产品编辑人员" v-model="model.editAdminName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">海关编码：</text></view>
                  <input  placeholder="请输入海关编码" v-model="model.declarationCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">退税率：</text></view>
                  <input type="number" placeholder="请输入退税率" v-model="model.taxRate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">包裹重量(kg)：</text></view>
                  <input type="number" placeholder="请输入包裹重量(kg)" v-model="model.packWeight"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">终审用户ID：</text></view>
                  <input type="number" placeholder="请输入终审用户ID" v-model="model.checkAdminId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">终审用户姓名：</text></view>
                  <input  placeholder="请输入终审用户姓名" v-model="model.checkAdminName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">开发备注：</text></view>
                  <input  placeholder="请输入开发备注" v-model="model.toDevelopMemo"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">禁售平台：</text></view>
                  <input  placeholder="请输入禁售平台" v-model="model.noSalePlatform"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">品牌：</text></view>
                  <input  placeholder="请输入品牌" v-model="model.brandName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否组合产品：</text></view>
                  <input type="number" placeholder="请输入是否组合产品" v-model="model.isGroup"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">规格型号：</text></view>
                  <input  placeholder="请输入规格型号" v-model="model.productSpec"/>
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
        name: "LdwProductInfoForm",
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
                  queryById: "/ldw/ldwProductInfo/queryById",
                  add: "/ldw/ldwProductInfo/add",
                  edit: "/ldw/ldwProductInfo/edit",
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
