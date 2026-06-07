package ir.ninjacoder.codesnap.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.codesnap.databinding.LayoutPrograsbarBinding;

public class ProgressDialog {
  public enum StateMode {
    V,
    H;
  }

  private Context ctx;
  private StateMode mod = StateMode.V;
  protected LayoutPrograsbarBinding bind;
  AlertDialog mAlertDialog = null;
  MaterialAlertDialogBuilder mDialogBuilder = null;

  public ProgressDialog(Context ctx) {
    this.ctx = ctx;
    this.mod = mod;
    bind = LayoutPrograsbarBinding.inflate(LayoutInflater.from(ctx));
    mDialogBuilder =
        new MaterialAlertDialogBuilder(ctx).setView(bind.getRoot()).setCancelable(true);
  }

  public int getProgress() {
    return bind.prograssbar.getProgress();
  }

  public void show() {
    mAlertDialog = mDialogBuilder.create();
    mAlertDialog.show();
  }

  public void dismiss() {
    mAlertDialog.dismiss();
  }

  public void setIcon(int resourceID) {
    mDialogBuilder.setIcon(resourceID);
  }

  public void setIcon(Drawable icon) {
    mDialogBuilder.setIcon(icon);
  }

  public void setMessage(int resourceID) {
    mDialogBuilder.setMessage(resourceID);
  }

  public void setMessage(CharSequence charSequence) {
    mDialogBuilder.setMessage(charSequence);
  }

  public void setTitle(int resourceID) {
    mDialogBuilder.setTitle(resourceID);
  }

  public void setTitle(CharSequence charSequence) {
    mDialogBuilder.setTitle(charSequence);
  }

  public void setIndeterminate(boolean b) {
    bind.prograssbar.setIndeterminate(b);
  }

  public void setMax(int max) {
    setIndeterminate(false);
    bind.prograssbar.setMax(max);
  }

  public void updateProgress(int progress) {
    if (bind.prograssbar.getProgress() < bind.prograssbar.getMax()) {
      bind.prograssbar.setProgress(bind.prograssbar.getProgress() + progress);
    } else {
      bind.prograssbar.setProgress(0);
      setIndeterminate(true);
    }
  }
}
