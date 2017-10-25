package com.github.darsha1509.sample3;

import com.github.darsha1509.sample3.api.AppVersion;
import com.github.darsha1509.sample3.parse.VersionListener;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk=26)
public class AppVersionTest {
    @Spy
    VersionListener listener;

    @Spy
    private AppVersion mAppVersion;

    @Captor
    ArgumentCaptor<AppVersion> versionCaptor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenNotUseCaptorAnnotation_thenCorrect() {
        AppVersion appVersion = mock(AppVersion.class);
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        appVersion.setVersionCode("3");
        verify(appVersion).setVersionCode(arg.capture());

        assertEquals("3", arg.getValue());

        doReturn("4").when(appVersion).getVersionCode();

        assertEquals("4", appVersion.getVersionCode());
    }

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        doReturn("7").when(mAppVersion).getVersionCode();

        listener.setResult(mAppVersion);
        verify(listener).setResult(versionCaptor.capture());

        assertEquals("7", versionCaptor.getValue().getVersionCode());

    }

}
