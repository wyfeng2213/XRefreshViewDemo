import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

//package com.example.administrator.xrefreshviewdemo.photo;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.widget.GridLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.RadioButton;
//import android.widget.TextView;
//
//import com.cmcc.healthlibrary.utils.ImageUtils;
//import com.cmcc.healthlibrary.utils.KeyboardUtils;
//import com.cmcc.healthlibrary.utils.StringUtils;
//import com.cmcc.healthlibrary.utils.ToastUtil;
//import com.cmcc.patient.Constans;
//import com.cmcc.patient.MyApplication;
//import com.cmcc.patient.R;
//import com.cmcc.patient.entity.AddCaseResult;
//import com.cmcc.patient.entity.SelectCaseListResult;
//import com.cmcc.patient.http.HttpMethods;
//import com.cmcc.patient.presenter.CasePresenter;
//import com.cmcc.patient.presenter.impl.CasePresenterImpl;
//import com.cmcc.patient.ui.base.BasePhotoActivity;
//import com.cmcc.patient.ui.view.CalendarDialogListener;
//import com.cmcc.patient.ui.view.DialogGLC;
//import com.cmcc.patient.utils.DialogUtils;
//import com.cmcc.patient.utils.PreferenceUtils;
//import com.cmcc.patient.view.CaseView;
//import com.jph.takephoto.model.TResult;
//import com.simple.commonadapter.RecyclerAdapter;
//import com.simple.commonadapter.viewholders.RecyclerViewHolder;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//
///**
// * 添加病历
// * 主要方法:
// * startActivity  启动activity
// * initView 初始化界面
// * initData 初始化数据
// * takeCancel 取消拍照
// * takeFail  拍照或者选择相册图片失败回调
// * takeSuccess 拍照或者选择相册成功回调
// * setRecyle 设置recyleview
// * showPop
// * showInDialog
// * addOneImage 添加图片
// * addCaseSuccss 添加病历成功的回调
// * selectCaseSuccess 查询病历成功
// */
//public class AddCaseActivity extends BasePhotoActivity implements CaseView {
public class AddCaseActivity extends Activity {
//
//    @BindView(R.id.tv_center)
//    TextView tvCenter;
//    @BindView(R.id.tv_right)
//    TextView tvRight;
//    @BindView(R.id.tv_select_calendar)
//    TextView tvSelectCalendar;
//    @BindView(R.id.recyleview)
//    RecyclerView recyclerView;
//    @BindView(R.id.tv_add)
//    TextView tvAdd;
//    @BindView(R.id.edt_result)
//    EditText edtResult;
//    CasePresenter casePresenter;
//    Map<String, RequestBody> bodyMap = new HashMap<>();
//    int countImage = 3;
//    int remaindImage = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_case);
//        ButterKnife.bind(this);
//        initView();
//        initData();
//    }
//
//    public static void startActivity(Context context) {
//        Intent starter = new Intent(context, AddCaseActivity.class);
////        starter.putExtra();
//        Activity activity = (Activity) context;
//        activity.startActivityForResult(starter, MyCaseActivity.CASE_REQULTCODE);
//    }
//
//    @Override
//    public void initView() {
//        tvCenter.setText(getString(R.string.str_addcases));
//        tvRight.setVisibility(View.VISIBLE);
//        tvRight.setText(getString(R.string.str_finish));
//
//        //设置选择图片的个数
//        View contentView = LayoutInflater.from(this).inflate(R.layout.common_layout, null);
//        ((EditText) contentView.findViewById(R.id.etLimit)).setText(countImage + "");
//        RadioButton rbCropYesb = (RadioButton) contentView.findViewById(R.id.rbCropYes);
//        RadioButton rbCropNo = (RadioButton) contentView.findViewById(R.id.rbCropNo);
//        rbCropYesb.setChecked(false);
//        rbCropNo.setChecked(true);
//        customHelper = CustomHelper.of(contentView);
//    }
//
//    @Override
//    public void initData() {
//        casePresenter = new CasePresenterImpl(this, this);
//        filePathList.add("");
//        setRecyle();
//    }
//
//    @Override
//    public void takeCancel() {
//        super.takeCancel();
//    }
//
//    @Override
//    public void takeFail(TResult result, String msg) {
//        super.takeFail(result, msg);
//    }
//
//    /**
//     * 拍照或者选择相册成功之后
//     *
//     * @param result
//     */
//    @Override
//    public void takeSuccess(TResult result) {
//        super.takeSuccess(result);
////        String path = result.getImage().getCompressPath();
////        ImageUtils.Loader(mContext, path, imgHead, ImageUtils.LOAD_CICLE);
//        this.Tresult = result;
//        filePathList.remove(filePathList.size() - 1);
//        //设置剩下可选的图片个数
//        remaindImage = countImage - result.getImages().size();
//        customHelper.setEtLimit(remaindImage);
//        for (int i = 0; i < result.getImages().size(); i++) {
//            if (result.getImages().get(i).getCompressPath() != null) {
//                filePathList.add(result.getImages().get(i).getCompressPath());
//            }
//        }
//        if (filePathList.size() < countImage) {
//            filePathList.add("");
//        }
//        setRecyle();
//
//    }
//
//    TResult Tresult;
//    List<String> filePathList = new ArrayList<>();
//
//
//    public void setRecyle() {
//        recyclerView.setVisibility(View.VISIBLE);
//        // 线性
//        recyclerView.setLayoutManager(new GridLayoutManager(this, countImage));
//        // 初始化adapter
//        final RecyclerAdapter<String> adapter = new RecyclerAdapter<String>(R.layout.item_photo, filePathList) {
//            @Override
//            protected void onBindData(RecyclerViewHolder viewHolder, int position, String item) {
//                ImageView imageView = viewHolder.findViewById(R.id.photo_image);
//                if ("".equals(item)) {
//                    ImageUtils.Loader(mContext, R.mipmap.img_add, imageView, ImageUtils.LOAD_ROUND);
//                    imageView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            showPop();
//                        }
//                    });
//                } else {
//                    ImageUtils.Loader(mContext, item, imageView, ImageUtils.LOAD_ROUND);
//                }
//            }
//        };
//        recyclerView.setAdapter(adapter);
//    }
//
//    private CustomHelper customHelper;
//    private DialogGLC mDialog;
//
//    /**
//     * 选择相册
//     */
//    public void showPop() {
//        DialogUtils.getInstance().showBottomPop2(this, R.layout.pop_photo);
//        View view = DialogUtils.getInstance().getPopView();
//        TextView tvPickBySelect = (TextView) view.findViewById(R.id.btnPickBySelect);
//        TextView tv_cancle = (TextView) view.findViewById(R.id.tv_cancle);
//        tvPickBySelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                customHelper.onClick(view, getTakePhoto());
//                DialogUtils.getInstance().dismissPopupWindow();
//            }
//        });
//        TextView tvPickByTake = (TextView) view.findViewById(R.id.btnPickByTake);
//        tvPickByTake.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                customHelper.onClick(view, getTakePhoto());
//                DialogUtils.getInstance().dismissPopupWindow();
//            }
//        });
//        tv_cancle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogUtils.getInstance().dismissPopupWindow();
//            }
//        });
//    }
//
//    String date;
//
//    /**
//     * 日历弹出框
//     */
//    private void showInDialog() {
//        mDialog = new DialogGLC(this);
//        if (mDialog.isShowing()) {
//            mDialog.dismiss();
//        } else {
//            mDialog.setCancelable(true);
//            mDialog.setCanceledOnTouchOutside(true);
//            mDialog.show();
//            //better initialize NumberPickerView's data (or set a certain value)
//            // every time setting up reusable dialog
//            mDialog.initCalendar();
//        }
//        mDialog.setDialogListener(dialogListener);
//    }
//
//
//    CalendarDialogListener dialogListener = new CalendarDialogListener() {
//        @Override
//        public void getdata(Calendar calendar) {
//            String data = calendar.get(Calendar.YEAR) + "-"
//                    + (calendar.get(Calendar.MONTH) + 1) + "-"
//                    + calendar.get(Calendar.DAY_OF_MONTH);
//            date = tvSelectCalendar.getText().toString();
//            if (calendar.getTimeInMillis() > System.currentTimeMillis()) {
//                ToastUtil.show(mContext, "选择的日期不能大于当前日期");
//            } else {
//                tvSelectCalendar.setText(data);
//            }
//        }
//    };
//
//    @OnClick({R.id.layout_left, R.id.tv_right, R.id.tv_select_calendar, R.id.tv_add})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.layout_left:
//                finish();
//                break;
//            case R.id.tv_right:
//                String paintId = PreferenceUtils.getPrefString(mContext, Constans.KEY_LOGINID, "");
//                String name = PreferenceUtils.getPrefString(mContext, Constans.KEY_USERNAME, "");
//                String result = edtResult.getText().toString();
//
//                if (StringUtils.isEmpty(date)) {
//                    ToastUtil.show(mContext, "日期不能为空");
//                    return;
//                }
//
//                if (StringUtils.isEmpty(result)) {
//                    ToastUtil.show(mContext, "确认结果不能为空");
//                    return;
//                }
//
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("patinetLoginId", paintId);
//                    jsonObject.put("patinetName", name);
//                    jsonObject.put("diagnoseDate", date);
//                    jsonObject.put("diagnoseContent", "");
//                    jsonObject.put("diagnoseResult", result);
//                    jsonObject.put("mechanism", "");
//                    jsonObject.put("sourceType", 1);
//                    jsonObject.put("details", "");
//                    jsonObject.put("doctorsLoginId", "");
//                    jsonObject.put("doctorsName", "");
//                    jsonObject.put("launchLoginId", "");
//                    jsonObject.put("launchName", "");
//                    jsonObject.put("note", "");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                String parameter = jsonObject.toString();
//                addOneImage(parameter);
//                break;
//            case R.id.tv_select_calendar:
//                showInDialog();
//                break;
//            case R.id.tv_add:
//                KeyboardUtils.hideSoftInput(mContext, edtResult);
//                showPop();
//                break;
//        }
//    }
//
//    private void addOneImage(String parameter) {
//        if (filePathList.size() == 0) {
//            ToastUtil.show(mContext, "请上传病历图片");
//            return;
//        }
//        String equipmentData = HttpMethods.getInstance().getLocalInfo(MyApplication.getInstance(), HttpMethods.REOLE);
//        RequestBody requestBody;
//        File file;
//        MultipartBody.Builder builder = new MultipartBody.Builder();
//        builder.setType(MultipartBody.FORM)
//                .addFormDataPart("patientMedicalRecord", parameter)
//                .addFormDataPart("equipmentData", equipmentData);
//        for (int i = 0; i < filePathList.size(); i++) {
//            file = new File(filePathList.get(i));
//            builder.addFormDataPart("files", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
//        }
//        requestBody = builder.build();
//        casePresenter.addCaseBody(requestBody);
//    }
//
//    @Override
//    public void addCaseSuccss(AddCaseResult addCaseResult) {
//        setResult(MyCaseActivity.CASE_RESULTCODE, getIntent());
//        finish();
//        toast("添加成功");
//    }
//
//    @Override
//    public void selectCaseSuccess(SelectCaseListResult caseListResult) {
//
//    }
//
//    @Override
//    public void toast(String content) {
//        ToastUtil.show(mContext, content);
//    }
}
