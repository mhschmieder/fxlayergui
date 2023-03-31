/**
 * MIT License
 *
 * Copyright (c) 2020, 2023 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxLayerGui Library
 *
 * You should have received a copy of the MIT License along with the
 * FxLayerGui Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxlayergui
 */
package com.mhschmieder.fxlayergui.action;

import java.util.Arrays;
import java.util.Collection;

import org.controlsfx.control.action.Action;

import com.mhschmieder.commonstoolkit.util.ClientProperties;
import com.mhschmieder.fxguitoolkit.action.FileActions;
import com.mhschmieder.fxguitoolkit.action.LabeledActionFactory;
import com.mhschmieder.fxguitoolkit.action.SettingsActions;
import com.mhschmieder.fxguitoolkit.action.ToolsActions;
import com.mhschmieder.fxguitoolkit.action.XActionGroup;

import javafx.scene.paint.Color;

/**
 * This is a struct-like container for actions used by Layer Management.
 */
public final class LayerManagementActions {

    public FileActions     _fileActions;
    public SettingsActions _settingsActions;
    public ToolsActions    _toolsActions;

    public LayerManagementActions( final ClientProperties pClientProperties ) {
        _fileActions = new FileActions( pClientProperties );
        _settingsActions = new SettingsActions( pClientProperties );
        _toolsActions = new ToolsActions( pClientProperties );
    }

    public Collection< Action > getBackgroundColorChoiceCollection() {
        // Forward this method to the Settings actions container.
        return _settingsActions.getBackgroundColorChoiceCollection();
    }

    public Collection< Action > getExportActionCollection() {
        // Forward this method to the File actions container.
        return _fileActions.getExportActionCollection( true, false );
    }

    public Collection< Action > getFileActionCollection( final ClientProperties pClientProperties ) {
        // Forward this method to the File actions container.
        return _fileActions.getFileActionCollection( pClientProperties, true, false );
    }

    public Collection< Action > getLayerManagementMenuBarActionCollection( final ClientProperties pClientProperties ) {
        final XActionGroup fileActionGroup = LabeledActionFactory
                .getFileActionGroup( pClientProperties, _fileActions, true, false );

        final XActionGroup settingsActionGroup = LabeledActionFactory
                .getSettingsActionGroup( pClientProperties, _settingsActions, true );

        final XActionGroup toolsActionGroup = LabeledActionFactory
                .getToolsActionGroup( pClientProperties, _toolsActions );

        final Collection< Action > layerManagementMenuBarActionCollection = Arrays
                .asList( fileActionGroup, settingsActionGroup, toolsActionGroup );

        return layerManagementMenuBarActionCollection;
    }

    public String getSelectedBackgroundColorName() {
        // Forward this method to the Settings actions container.
        return _settingsActions.getSelectedBackgroundColorName();
    }

    public Collection< Action > getSettingsActionCollection( final ClientProperties pClientProperties ) {
        // Forward this method to the File actions container.
        return _settingsActions.getSettingsActionCollection( pClientProperties, true );
    }

    public Collection< Action > getToolsActionCollection( final ClientProperties pClientProperties ) {
        // Forward this method to the Tools actions container.
        return _toolsActions.getToolsActionCollection( pClientProperties );
    }

    public Collection< Action > getWindowSizeActionCollection() {
        // Forward this method to the Settings actions container.
        return _settingsActions.getWindowSizeActionCollection( true );
    }

    public Color selectBackgroundColor( final String backgroundColorName ) {
        // Forward this method to the Settings actions container.
        return _settingsActions.selectBackgroundColor( backgroundColorName );
    }

}
